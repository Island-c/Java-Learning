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
		session.setAttribute("password","ad");
		session.setAttribute("age",20);
		//设置当前session最大生成期限  单位s
		//session.setMaxInactiveInterval(3);

		
	%>
	Session创建时间 ：<%=sfd.format(d)%><br>
	session获取用户id : <%=session.getId() %><br>
	Session保存的属性有：<br>
	<%
		String[] names = session.getValueNames();
		for(String n : names){
			out.println(n+"&nbsp;&nbsp"+session.getAttribute(n)+"<br>");
		}
	
	%><br>
	
	<%
		//销毁当前会话
		//session.invalidate();
	%>
	<a href="session_page2.jsp" target ="_blank">跳转到session_page2.jsp</a>
</body>
</html>



