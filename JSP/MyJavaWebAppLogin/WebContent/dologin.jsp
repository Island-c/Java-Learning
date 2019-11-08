<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>

<%
	String path =request.getContextPath();
	String basepath =request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
	
	String username ="";
	String password ="";
	
	request.setCharacterEncoding("utf-8"); //防止中文乱码
	
	username = request.getParameter("username");
	password = request.getParameter("password");
	
	if("admin".equals(username)&& "admin".equals(password))
	{
		session.setAttribute("loginUser", username);
		request.getRequestDispatcher("login_success.jsp").forward(request,response);	
		
	}else{
		response.sendRedirect("login_failure.jsp");
	}
	
%>

