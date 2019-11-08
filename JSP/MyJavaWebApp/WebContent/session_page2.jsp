<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>

<head>
<title>jsp练习</title>
</head>

<body>


	<h1>session练习</h1>
	<hr>
	<%
		SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
		Date d = new Date(session.getCreationTime());
		
		session.setAttribute("username","admin");
	%>
	Session创建时间 ：<%=sfd.format(d)%><br>
		session获取用户id : <%=session.getId() %>
	Session获取用户名::<%=session.getAttribute("username") %>
</body>
</html>



