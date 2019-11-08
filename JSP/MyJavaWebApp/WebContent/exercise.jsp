<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>九九乘法表</title>
</head>

<body>



<%!
	//返回99乘法表对应的html代码。通过表达式调用，在页面上显示
	String printMultiTable_1(){
		String s = "";
		for(int i=1;i<=9;i++){
			for(int j=1;j<=i;j++){
				s+=i+"*"+j+"="+(i*j)+"&nbsp;&nbsp;&nbsp;&nbsp;";
			}
		s+="<br>";
		}
		return s ;
	}

	//Jsp内置out对象。 使用脚本方式调用，在页面上显示
	void printMultiTable_2(JspWriter out) throws Exception{
		for(int i=1;i<=9;i++){
			for(int j=1;j<=i;j++){
				out.println(i+"*"+j+"="+(i*j)+"&nbsp;&nbsp;&nbsp;&nbsp;");
			}
			out.println("<br>");
		}
	}


%>
<h1>九九乘法表</h1>

<hr>
<%=printMultiTable_1() %>
<hr>
<% printMultiTable_2(out); %>
</body>
</html>



