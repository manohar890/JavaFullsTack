<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display by id</title>
</head>
<body>

<div align="center" style="margin-top: 180px">
<h3 style="color:pink;margin-right:150px">Details of Employee id ${data.id} :</h3>
<table style="border-color: green;" border=5px>
<tr>
	<td>Employee Id:</td><td>${data.id}</td>
</tr>
<tr>
	<td>Employee Name:</td><td>${data.empName}</td>
</tr>
<tr>
	<td>Employee Email:</td><td>${data.empEmail}</td>
</tr>
<tr>
	<td>Employee Location:</td><td>${data.empLocation}</td>
</tr>
</table>
</div>
</body>
</html>