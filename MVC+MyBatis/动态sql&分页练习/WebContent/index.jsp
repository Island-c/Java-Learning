<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>展示</title>
</head>


<body>

<h1>学生信息</h1>

<form action="page" method="post">

	每页显示条数：  2<input type="radio" name="pageSize" value=2 checked="true">   3<input type="radio" name="pageSize" value=3>  4<input type="radio" name="pageSize" value=4> <br/>
	学生姓名： <input type="text" name="student_name">  老师姓名：<input type="text" name="teacher_name">  <input type="submit" value="查询">
</form>	



<table border="1">
	
	<tr>
		<th>编号 </th>
		<th>学生姓名</th>
		<th>年龄</th>
		<th>老师姓名</th>
	</tr>
	<c:forEach items="${pageinfo.list}" var="student">
		<tr>
			<td>${student.id}</td>
			<td>${student.student_name}</td> 
			<td>${student.age}</td>
			<td>${student.teacher_name}</td>
		</tr> 
	</c:forEach>
</table> 


<a href="page?pageSize=${pageinfo.pageSize}&pageNumber=${pageinfo.pageNumber-1}&student_name=${pageinfo.student_name}&teacher_name=${pageinfo.teacher_name}" <c:if test="${pageinfo.pageNumber<=1 }"> onclick="javascript:return false"</c:if>>上一页</a>
<a href="page?pageSize=${pageinfo.pageSize}&pageNumber=${pageinfo.pageNumber+1}&student_name=${pageinfo.student_name}&teacher_name=${pageinfo.teacher_name}" <c:if test="${pageinfo.pageNumber>=pageinfo.count}"> onclick="javascript:return false"</c:if> >下一页</a>
<p>第 ${pageinfo.pageNumber} 页 ， 共${pageinfo.count}页</p>


</body>
</html>