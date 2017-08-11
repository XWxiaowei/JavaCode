<%--
  Created by IntelliJ IDEA.
  User: xiang.wei
  Date: 2017/6/21
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<script type="text/javascript"
        src="<%=request.getContextPath()%>/manage/Js/bootstrap.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="modal hide fade in" id="product-dialog" role="dialog"
     backdrop="static" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content message_align">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title">请选择产品</h4>
            </div>
            <div class="modal-body text-center" id="selectProduct">
                <form class="form-inline m10" id="selectMerchant">
                    <label><span>商户：</span></label>
                    <select id="productMerchant" name="productMerchant">
                        <c:forEach var="merchant" items="${merchants}">
                            <option value="${merchant.merchantId}"
                                    <c:if test="${merchant.merchantId==selectMerchantId}">
                                        selected="selected"
                                    </c:if>
                                    >${merchant.merchantName}</option>
                        </c:forEach>
                    </select>
                </form>
                <form class="form-inline  m5" id="addBatch" action="addBatch.html" method="POST">
                    <table class="table table-bordered table-hover  m5">
                        <thead>
                        <tr>
                            <th><input type="checkbox" id="parentCheck"></th>
                            <th style="min-width:80px;">商品ID</th>
                            <th style="min-width:100px;">商品名称</th>
                        </tr>
                        </thead>
                        <tbody id="data-panel">
                        <tr>
                            <td colspan="3">数据加载中...</td>
                        </tr>
                        </tbody>
                    </table>
                    <div class="bottom-nav">总记录数：<span id="total-count"></span>条，总页数<span id="total-pages">XXX</span>页，每页显示<span id="page-size"></span>条，当前是第<span id="page-num"></span>页。
                        <a id="first">第一页</a>
                        <a id="prev">上一页</a>
                        <a id="next">下一页</a>
                        <a id="last">最后一页</a>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button onclick="doCheck()" type="button" class="btn btn-success"
                        data-dismiss="modal" id="confirm">保存
                </button>
                <button type="button" class="btn btn-default" data-dismiss="modal"
                        id="cancel">取消
                </button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<style>
    #selectProduct {
        height: 300px;
        text-align: left;
    }
    #product-dialog {
        top:10px;
        text-align: left;
        position: absolute;
    }
   #selectMerchant{
       margin: 5px 0 10px 20px;
   }
    .bottom-nav{
        margin-top: 5px;
        border: 1px solid #ccc;
    }
    .bottom-nav a{
        cursor: pointer;
    }
</style>
<script>
    var PAGE_NO = 1;    //当前页
    var LAST_PAGE = 1;  //最后一页
    //保存
    function doCheck() {
        var selectedProduct = "[";
        var check = document.getElementsByName("checkIds");
        var displayid=$("#displayId").val();
        var platformid=$("#platformid").val();
        for (var i = 0; i < check.length; i++) {
            if (check[i].checked == true) {
                selectedProduct += "{\"platformid\":" + platformid + ",\"displayid\":" + displayid + ",\"productId\":" + check[i].value + ",\"productName\":\"\"},";
            }
        }
        var temp = selectedProduct.substring(selectedProduct.length - 1, selectedProduct.length); //如果最后一个字符是,则删除
        if ("," == temp) {
            selectedProduct = selectedProduct.substring(0, selectedProduct.length - 1); //删除最后一个,
        }
        selectedProduct += "]";
        $.post("addBatch.html",{displayProductVosJson:selectedProduct}, function(data,status){
            window.location.href="index.html?displayId="+displayid;
        });
    }
    //分页加载数据
    function pageFun(pageNo){
        $.ajax({
            type: "POST",
            url: "<%=request.getContextPath()%>/manage/tab2/displayProduct/getProducts.html",
            data: {
                displayid: $("#displayId").val(),
                merchantid: $('#productMerchant').val(),
                pageNo: pageNo
            },
            dataType: "json",
            success: function (data) {
                console.log(data);
                if (data.success) {
                    $('#total-count').html(data.total);  //总条数
                    $('#total-pages').html(Math.ceil(data.total/data.pageSize)); //总页数
                    LAST_PAGE = Math.ceil(data.total/data.pageSize);
                    $('#page-size').html(data.pageSize);
                    $('#page-num').html(data.pageNum);
                    PAGE_NO = data.pageNum;
                    var dataAll = data.data || [];
                    //循环插入数据
                    $('#data-panel').html('');//清空dom
                    if(dataAll.length>0){
                        $("#platformid").val(dataAll[0].platformid);
                        //解析数组
                        $.each(dataAll, function (i, item) {
                            $("#data-panel").append('<tr id="tr'+i+'"></tr>');
                            $('#tr'+i+'')
                                    .append('<td><input type="checkbox" name="checkIds" value= "'+ item.productId +'"></td>')
                                    .append('<td style="max-width: 130px;">' + item.productId + '</td>')
                                    .append('<td style="max-width: 250px;">' + item.productName + '</td>');
                        });
                    }else{
                        var noData = ' <tr><td colspan="3">暂无数据</td></tr>';
                        $('#data-panel').append(noData);
                    }
                }
            },
            error: function () {
                console.log("查询失败");
            }
        });
    }
    $('#first').on('click', function () {
        pageFun(1);
    });  //跳第一页
    $('#last').on('click', function () {
        pageFun(LAST_PAGE);
    });  //跳最后一页

    $('#prev').on('click', function () {
        PAGE_NO--;
        if (PAGE_NO <= 0) {
            pageFun(1);
        } else {
            pageFun(PAGE_NO);
        }
    });  //跳上一页

    $('#next').on('click', function () {
        PAGE_NO++;
        if (PAGE_NO > LAST_PAGE) {
            pageFun(LAST_PAGE);
        } else {
            pageFun(PAGE_NO);
        }
    });  //跳下一页
    //按照商户查找
   $("#productMerchant").change(function(){
        pageFun(PAGE_NO);
   });
  //全选,全不选
    $("#parentCheck").click(function(){
        if(document.getElementById('parentCheck').checked==true){
            $("input[name='checkIds']").each(function(){
                $(this).prop('checked',true);
            });
        }else{
            $("input[name='checkIds']").removeAttr('checked');
        }
    });
</script>
