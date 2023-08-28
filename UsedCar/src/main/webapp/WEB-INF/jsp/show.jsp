<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background-color: lime;">
<div align="center">
<h2>Available Cars:</h2>
<form action="booking" method="post">
	<table border="10px">
	<tr>
	<th></th>
	<th>Brand</th>
	<th>Model</th>
	<th>No.of Kms</th>
	<th>year</th>
	<th>fuel type</th>
	<th>price</th>
	</tr>
	<c:forEach var="datas" items="${data }">
	
	<tr>
	<td><input type="radio" value="${datas.id }" name="id"></td>
	<td>${datas.brand}</td>
	<td>${datas.model}</td>
	<td>${datas.kms}</td>
	<td>${datas.years}</td>
	<td>${datas.fuelType}</td>
	<td>${datas.price}</td>
	</tr>
	</c:forEach>
	<tr>
	<td><input type="submit" value="book"></td>
	<td><button><a href="/">Home</a></button></td>
	</tr>
	</table>
	</form>
</div>

</body>
</html>