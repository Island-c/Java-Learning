<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>ajax Data格式</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">

	<style type="text/css">
		#showdiv{
			border:solid 1px;
			width:200px;
			height:100px;
		}
	</style>
<!-- 
	需求：
		1.在当前页面显示查询结果，使用ajax
		2.创建ajax函数
		3. 调用ajax函数发送请求到UserServlet
		4.调用业务层获取对应的数据 

 -->
	<script type="text/javascript">
	//获取数据
	function getData(){
		//获取用户请求信息
		var name = document.getElementById("uname").value;
		//alert(name);
		var ajax=getAjax();
		
		//复写onreadystatechange
		ajax.onreadystatechange=function(){
			//判断ajax状态码
			if(ajax.readyState==4){
			
				if(ajax.status==200){
					//获取响应数据
					var result = ajax.responseText;
					//alert(result);					
					eval("var u="+result);
					//处理响应数据
					//获取table表格数据
					var ta = document.getElementById("ta");
					//插入新行
					var tr =ta.insertRow(1);
					var cell0=tr.insertCell(0);
					cell0.innerHTML=u.uid;
					var cell1=tr.insertCell(1);
					cell1.innerHTML=u.uname;
					var cell2=tr.insertCell(2);
					cell2.innerHTML=u.price;
					var cell3=tr.insertCell(3);
					cell3.innerHTML=u.location;
					var cell4=tr.insertCell(4);
					cell4.innerHTML=u.des;
				}
			} 
		}	
		//发送请求
		ajax.open("get","user?name="+name);
		ajax.send(null);
	}
	
	
	function getAjax(){
			//获取ajax引擎对象
		var ajax = null;
		if(window.XMLHttpRequest){
			ajax= new XMLHttpRequest();
		}else if (window.ActiveXObject){
			ajax = new ActiveXObject("Msxml2.XMLHTTP");	
		}
		return ajax;
	}
	</script>
  </head>

  <body>
    <h3>欢迎访问</h3>
    <hr>
    请输入搜索的内容：<input type="text" name= "uname" value="" id="uname">  
    <input type="button" value="搜索" onclick="getData()">
    <hr>
   	<table border="1px" id="ta">
   		<tr>
   			<td>编号</td>
   			<td>名称</td>
   			<td>价格</td>
			<td>位置</td>
   			<td>描述</td>   			
   		</tr>
   	</table>
  </body>
</html>
