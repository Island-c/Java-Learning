<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>jsp练习</title>
</head>

<body>


	<h1>用户注册</h1>
	<hr>
	<!-- 下面是一个表单，action标明了表单提交给谁，type="submit"表名按钮触发提交操作 -->
	<form action ="response.jsp" name ="regForm" method ="post">
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
		<tr>
			<td>爱好：</td>
			<td>
			<input type="checkbox" name ="favorite" value="read"> 读书
			<input type="checkbox" name ="favorite" value="music"> 音乐
			<input type="checkbox" name ="favorite" value="movie"> 电影
			<input type="checkbox" name ="favorite" value="internet"> 上网
			</td> 
		</tr>
		<tr>
			<td colspan ="2"><input type="submit" value ="提交"></td> 
		</tr>		
		</table>
	</form>
	
	<br>
	<br>
	
	<a href="request.jsp?username=啊&password=11&favorite=read">测试url传参数</a><br>
	<a href="request.jsp?username=lisi&favorite=read&password=11">测试url传参数2</a>

	
</body>
</html>



