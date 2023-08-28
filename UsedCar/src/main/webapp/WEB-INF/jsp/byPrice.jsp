<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background-color: red;">
<div align="center" style="margin-top: 300px">
<form action="/searching" method="post">
<table>
<tr>
	<td><input type="radio" value="5" name="range"> < 5 lakhs</td>
	</tr>
<tr>
	<td><input type="radio" value="6" name="range"> > 5 lakhs<td>
	
	</tr>
	<tr>
	<td><input type="submit" value="find"></td>
	
	</tr>
	</table>
</form>
<button><a href="/">Home</a></button>
</div>
</body>
</html>