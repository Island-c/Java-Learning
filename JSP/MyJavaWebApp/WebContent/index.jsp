<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ page import="java.text.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>啊</title>
</head>
<body>
	<h1>welcome</h1>
	
	<%!
		String s ="张三";//声明字符串变量
		int add(int x, int y){  //声明一个返回类型为int的函数 
			return x+y;
		}
	%>
	<hr>
	<% 
		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日");
		String s = df.format(new Date());
		
	%>
	今天是：<%=s %><hr>
	
	<!--HTML注释  ，， 客户端可见-->
	<%--JSP注释，客户端不可见 --%> 

	<%
		//在jsp脚本中：单行注释  
		/*
		多行注释
		*/
		
		out.println("Hello world");
	%>
	
	<br>
	你好，<%= s %><br>
	x+y=<%=add(10,5) %>
</body>
</html>


