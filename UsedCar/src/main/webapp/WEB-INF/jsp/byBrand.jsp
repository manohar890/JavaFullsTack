<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search by brand</title>
</head>
<body style="background-color: yellow;">
<div align="center" style="margin-top: 200px">
<h3>
Search for car:
</h3>
<form action="/search" method="post">
<table border="10px" width="500px"> 
<tr>
<td>choose a car:</td>
<td>
<select name="brand">
	<option value="all">All</option>
	<option value="hyundai">hyundai</option>
	<option value="honda">honda</option>
	<option value="volvo">volvo</option>
	<option value="wv">wv</option>
	<option value="suzuki">suzuki</option>
	<option value="ford">ford</option>
    
</select>
</td>
</tr>
<tr>

<td><input type="submit" value="find Models"> </td><td><button><a href="/">back</a></button></td>
</tr>
</table>
</form>
</div>
</body>
</html>