<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>UEditor</title>
    <script type="text/javascript">
        var basePath = "<%=basePath%>";
    </script>
    <script type="text/javascript" src="../static/lib/jquery-1.12.0.min.js"></script>
    <script type="text/javascript" src="../static/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" src="../static/ueditor/ueditor.all.js"></script>
    <script type="text/javascript" src="../static/ueditor/lang/zh-cn/zh-cn.js"></script>
</head>
<body>
<div>
    <%--<input type="hidden" class="span12 required" name="info" id="info"/>--%>
    <script id="editor" type="text/plain" style="width:1024px;height:500px;"></script>
</div>
<script>

    var ue = UE.getEditor('editor');
    ue.ready(function () {
        ue.setContent('内容');
    });

</script>
</body>
</html>