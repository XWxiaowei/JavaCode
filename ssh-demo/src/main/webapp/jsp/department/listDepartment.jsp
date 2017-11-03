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
    <title>部门列表</title>
</head>
<body>
    <table border="0" width="900px">
        <tr>
            <td align="center" style="font-size: 24px; color: #666">部门管理</td>
        </tr>
        <tr>
           <td align="right">
               <a href="department_goAddDepartment.action">添加</a>
           </td>
        </tr>
    </table>
    <table cellspacing="0" border="1" class="table1">
        <thead>
            <th width="300">部门名称</th>
            <th width="300">描述</th>
            <th width="300">编辑</th>
            <th width="300">删除</th>
        </thead>
        <tbody>
            <s:iterator value="departmentList" var="department">
                <tr>
                    <td align="center"><s:property value="#department.dname"/></td>
                    <td align="center"><s:property value="#department.ddesc"/></td>
                    <td align="center">
                        <!-- 编辑部门update-->
                        <a href="department_findById.action?did=<s:property value="#department.did"/>">
                            <img src="${pageContext.request.contextPath }/images/mark.png" />
                        </a>
                    </td>
                    <td align="center">
                        <!-- 删除部门 -->
                        <a href="department_delete.action?did=<s:property value="#department.did"/>">
                            <img src="${pageContext.request.contextPath }/images/trash.gif" />
                        </a>
                    </td>
                </tr>
            </s:iterator>
        </tbody>
    </table>
</body>
</html>
