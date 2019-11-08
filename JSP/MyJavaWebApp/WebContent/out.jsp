<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>jsp练习</title>
</head>

<body>


	<h1>内置对象练习</h1>
	<hr>
	<%
		out.println("<h2>苟</h2>");
		out.println("苟利国家生死以<br>");
		out.flush();
		out.clearBuffer();
		out.println("岂因祸福避趋之<br>");
	%>
	<hr>
	缓冲区大小： <%= out.getBufferSize() %>byte<br>
	缓冲区剩余大小： <%= out.getRemaining() %>byte<br>
	是否自动清空缓冲区：<%=out.isAutoFlush() %>
</body>
</html>



