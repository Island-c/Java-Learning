<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>

<head>
<title>jsp练习</title>
</head>

<body>


	<h1>pageContext练习</h1>
	<hr>
	用户名是：<%=pageContext.getSession().getAttribute("username")%><br>
	
	<%
	//跳转到注册页面
	//pageContext.forward("reg.jsp");
	pageContext.include("include.jsp");
	%>
	 	
</body>
</html>



