<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" errorPage="exception.jsp"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>jsp练习</title>
</head>

<body>


	<h1>异常练习</h1>
	<hr>
	
	<%
		out.println(100/0); //抛出运行时异常  算数异常
	%>
	
	
</body>
</html>



