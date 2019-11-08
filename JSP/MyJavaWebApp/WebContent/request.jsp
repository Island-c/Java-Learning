<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>jsp练习</title>
</head>

<body>
	<h1>request练习</h1>
	<%
		request.setCharacterEncoding("utf-8");
		request.setAttribute("password","123456");
	%>
	<hr>
	<h1>登录成功</h1>
	用户名：<%=request.getParameter("username") %><br>
	密码：<%=request.getAttribute("password") %><br>
	爱好：<%
		if(request.getParameterValues("favorite")!=null){
			String[] fav = request.getParameterValues("favorite");
			for(String s:fav){
				out.println(s);
			}
		}
	%>
	<br>
	请求体的MINE类型： <%=request.getContentType() %><br>
	协议类型和版本号： <%=request.getProtocol() %><br>
	服务器主机名：<%=request.getServerName() %><br>
	服务器端口号：<%=request.getServerPort() %><br>
	请求的真实路径：<%=request.getRealPath("request.jsp") %><br>
	

</body>
</html>



