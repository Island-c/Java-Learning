<%@ page language="java" import="java.util.*,com.lc.pojo.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<html>
<head>
	<base href="<%=basePath%>">
	<meta charset="UTF-8">
	<title>Basic Form - jQuery EasyUI Demo</title>
	<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="themes/icon.css">
	<link rel="stylesheet" type="text/css" href="css/demo.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
</head>
<body>
	<div style="margin:20px 0;"></div>
	<div class="easyui-panel" title="用户注册" style="width:600px">
		<div style="padding:10px 60px 20px 60px">
	    <form action ="user" method="get" >
	    	<input type="hidden" name="oper" value="reg">
	    	<table cellpadding="5"> 
	    		<tr>
	    			<td>用户名:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" name="uname" data-options= "required:true" missingMessage="用户名必填"></input></td>
	    		</tr>
	    		<tr>
	    			<td>密码:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" name="pwd" data-options= "required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>性别：</td>
	    			<td>
	    				男：<input type="radio" name ="sex" value="1">
	    				女：<input type="radio" name ="sex" value="0">
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>年龄:</td>
	    			<td><input class="textbox" name="age"></input></td>
	    		</tr>
	    		<tr>
	    			<td>出生年月:</td>
	    			<td>
	    				<input class="easyui-datebox" name="birth"></input>
	    			</td>
	    		</tr>
	    		<tr>
	    			
	    			<td colspan="2" align="center">
	    				<input  type="submit" value="注册" ></input>
	    			</td> 
	    		</tr>
	    	</table>
	    </form>

	    </div>
	</div>

</body>
</html>
