<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>ajax</title>
   	<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
	
	<style type="text/css">
		#showdiv{
			border:solid 1px ;
			width :200px;
			height:100px;
		}
	
	</style>
	
	<script type="text/javascript">
	
		function getDate(){
		//获取元素对象
			var div = document.getElementById("showdiv");
			div.innerHTML="哈哈，雾霾";
		
		}
	
	</script>


  </head>
  
  <body>
		<h3>欢迎登录</h3>
		<hr>
		
		<input type="button" value="测试" onclick="getDate()"/>
		<div id= "showdiv">
		
		</div>
  </body>
</html>
