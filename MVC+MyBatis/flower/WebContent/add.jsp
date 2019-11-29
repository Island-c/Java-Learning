<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript">
//页面加载完成后执行
//相当于 window.onload=function(){}  $(document).ready(function)
$(function(){
	
	$("form").submit(function(){
		//表单选择器  input标签 type属性值
		if($(":text:eq(0)").val()=="" ||$(":text:eq(1)").val()=="" ||$(":text:eq(2)").val()=="" ){
			alert("请填写完整信息");
			//组织默认行为
			return false;
		}
	})
	
	
});
</script>
</head>
<body>
<form action="insert" method = "post">
	<table border="1">
		<tr colspan="2" style="text-align:center; font-size:30px;font_weight:bold">
			花卉信息
		</tr>
		
		<tr>
			<td><b>花卉名称</b></td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td><b>花卉价格</b></td>
			<td><input type="text" name="price"></td>
		</tr>	
		<tr>
			<td><b>原产地</b></td>
			<td><input type="text" name="production"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="提交"/> <input type="reset" value="重置"/>
			</td>

		</tr>
	</table>
</form>	
</body>
</html>