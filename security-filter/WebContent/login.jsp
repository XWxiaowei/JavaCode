<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录窗体</title>
<script src="<%=request.getContextPath()%>/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
	function doLogin() {
		$('#login').submit();
	}
</script>
</head>
<body>
	<form action="<%=request.getContextPath() %>/LoginServlet.do">
		<table>
		<tr>
			<td><label>用户名:</label></td>
			<td><input type="text" name="userName"></td>
		</tr>
		<tr>
			<td><label>密码:</label></td>
			<td><input type="password" name="password"></td>
		</tr>
		<tfoot>
			<tr>
			  <td><input type="submit" id="login" onclick="doLogin()" value="登录"></td>
			  <td></td>
			</tr>
		</tfoot>
	</table>
	</form>
</body>
</html>