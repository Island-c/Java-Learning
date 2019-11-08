<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>jsp练习</title>
</head>

<body>


	<h1>用户登录</h1>
	<hr>
	<form action ="dologin.jsp" name ="loginForm" method ="post">
		<table>
		<tr>
			<td>用户名：</td>
			<td><input type="text" name ="username"></td> 
		</tr>
		<tr>
			<td>密码：</td>
			<td><input type="text" name ="password"></td> 
		</tr>
		<tr>
			<td colspan ="2"><input type="submit" value ="登录"></td> 
		</tr>		
		</table>
	</form>
</body>
</html>



