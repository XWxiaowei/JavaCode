<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: maerfeifei
  Date: 2017/10/15
  Time: 上午8:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改部门</title>
</head>
<body>
<table border="0" width="600px">
    <tr>
        <td align="center" style="font-size: 24px;color: #666666;">编辑部门</td>
    </tr>
    <tr>
        <td align="right">
            <a href="javascript:document.getElementById('saveForm').submit()">保存</a>
            <a href="javascript:history.go(-1)">返回</a>
        </td>
    </tr>
</table>
<s:form id="saveForm" action="department_update" method="post" namespace="/">
    <s:hidden name="did" value="%{model.did}"></s:hidden>
    <table style="font-size:16px" width="600px">
        <tr>
            <td width="30%" align="right">部门名称：</td>
            <td><s:textfield name="dname" value="%{model.dname}"/></td>
        </tr>
        <tr>
            <td width="30%" align="right">部门介绍：</td>
            <td></td>
        </tr>
        <tr>
            <td width="30%" align="right"></td>
            <td><s:textarea rows="5" cols="50" name="ddesc" value="%{model.ddesc}"></s:textarea></td>
        </tr>
    </table>
</s:form>
</body>
</html>
