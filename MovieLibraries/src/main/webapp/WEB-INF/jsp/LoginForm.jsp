<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background-color: fuchsia;">
<div align=center  style="margin-top:200px">
<h3>Enter Login Details:</h3>
<form action="/Login" method="post">
<table border="2px" style="width: 400px">
<tr>
<td>Enter UserName:</td><td><input type="text" name="username"></td>
</tr>
<tr>
<td>Enter Password:</td><td><input type="text" name="password"></td>
</tr>
<tr>
<td></td><td><input type="Submit" value="Login"></td>
</tr>
</table>

</form>
<a href="/">Home</a>
</div>
</body>
</html>