<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>

<head>
<title>jsp练习</title>
</head>

<body>


	<h1>application练习</h1>
	<hr>
	<%
		application.setAttribute("city", "123 ");
		application.setAttribute("postcode", "10000");
	
	%>
	所在城市是：<%=application.getAttribute("city") %><br>
	postcode是：<%=application.getAttribute("postcode") %>
	
</body>
</html>



