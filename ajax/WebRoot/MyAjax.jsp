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
		//1.创建ajax引擎对象
			var ajax;
			if(window.XMLHttpRequest){ //火狐
				ajax = new XMLHttpRequest(); 
			}else if (window.ActiveXObject){ //ie
				ajax = new ActiveXObject("Msxm12.XMLHTTP");
			}
		//复写onreadystatement函数
		//readystatement的值改一次，该函数执行一次
			ajax.onreadystatechange = function(){
			//判断ajax状态码
				if(ajax.readyState==4){
				//判断响应状态码s
					if(ajax.status==200){
						//获取响应内容
						var result = ajax.responseText;
						//处理响应内容
						//alert(result);
						//获取元素对象
						var div = document.getElementById("showdiv");
						div.innerHTML=result;
					}else if(ajax.status==404){
						var div = document.getElementById("showdiv");
						div.innerHTML="请求资源不存在";
					}else if(ajax.status==500){
						var div = document.getElementById("showdiv");
						div.innerHTML="服务器繁忙";
					}
				} else{
						var div = document.getElementById("showdiv");
						div.innerHTML="<img src = 'img/2.gif' width='200px' height='100px' / >";
				}
			}  
		//发送请求
			ajax.open("get", "ajax"); //get请求时，请求参数拼接在url后面； 最后一个参数控制同步or异步  默认异步。
			ajax.send(null); //用于post请求时  ; 所以两个都得写
			alert("哈哈"); //异步执行， 不等response ， 先往下执行。 
		}
	</script>
 
  </head>
  <body>
		<h3>欢迎登录</h3>
		<hr> 
		<input type="button" value="测试" onclick="getDate()"/>
		<div id= "showdiv">
		aaaab123
		</div>
  </body>
</html>

