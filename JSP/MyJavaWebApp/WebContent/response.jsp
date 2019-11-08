<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*,java.io.*" contentType="text/html; charset=utf-8"%>
<%
	response.setContentType("text/html ;charset = utf-8");

	out.println("<h1>response内置对象</h1>");
	out.println("<hr>");
	
	
	//获得输出流对象
	PrintWriter outer = response.getWriter();
	outer.println("response对象生成的输出流outer");
	
	/*请求重定向*/
	//response.sendRedirect("request.jsp"); //请求重定向
	
	/*请求转发*/
	request.getRequestDispatcher("request.jsp").forward(request, response);
%>


