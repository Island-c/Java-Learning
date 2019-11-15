<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>ajax request练习</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">

	<style type="text/css">
		#showdiv{
			border:solid 1px;
			width:200px;
			height:100px;
		}
	</style>

	<script type="text/javascript">
	function ajaxReq(){
		//获取用户请求数据 
		var uname= document.getElementById("uname").value;
		var pwd= document.getElementById("pwd").value;
		var data = "name="+uname+"&"+"pwd="+pwd;
		
		//创建ajax引擎对象
		var ajax;
		
		if(window.XMLHttpRequest){
			ajax = new XMLHttpRequest();
		}else if ( window.ActiveXObject){
			ajax =new ActiveXobject("Msxm12.XMLHTTP");
		}
		//复写onreadystatement函数
		
		ajax.onreadystatechange=function(){
			//判断ajax状态码
			if(ajax.readyState == 4){
				//判断响应状态吗
				if(ajax.status == 200){
				//获取响应内容
					var result = ajax.responseText;
					//处理响应内容
					alert(result);
				}
			}
		}
		//发送请求
			//get方式: 请求实体拼在url后面
		//	ajax.open("get","ajax?"+data);
		//	ajax.send(null);
			//post方式 请求实体需要单独发送
			ajax.open("post","ajax");
			ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			ajax.send(data);
	}
	
	</script>
  </head>
  
  <body>
    <h3>ajax request</h3>
    
    <hr>
    
 用户名： <input type="text" name ="name" value="" id="uname"/><br>
 密码：    <input type="text" name ="password" value="" id="pwd"/><br>
    <input type ="button" value="测试" onclick="ajaxReq()"/>
    
    
    <div id = "showdiv"> 
   		aaaaa
    </div>
    
    
  </body>
</html>
