<%--
  Created by IntelliJ IDEA.
  User: maerfeifei
  Date: 2017/10/15
  Time: 上午8:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>修改部门</title>
</head>
<body>
<table border="0" width="600px">
    <tr>
        <td align="center" style="font-size: 24px; color: #666">部门添加</td>
    </tr>
    <tr>
        <td align="right">
            <a href="javascript:document.getElementById('saveForm').submit()">保存</a>
            &nbsp;&nbsp;
            <a href="javascript:history.go(-1)">退回 </a>
        </td>
    </tr>
</table>
<br/>
<br/>
<!-- action对应一个action标签，id对应提交时的对应关系 -->
<s:form id="saveForm" action="department_saveDepartment" method="post" namespace="/" theme="simple">
    <table style="font-size:16px"width="600px">
        <tr>
            <td width="30%" align="right">部门名称：</td>
            <td><s:textfield name="dname"/></td>
        </tr>
        <tr>
            <td width="30%" align="right">部门介绍：</td>
            <td><s:textarea rows="5" cols="50" name="ddesc"/></td>
        </tr>
    </table>
</s:form>
</body>
</html>
