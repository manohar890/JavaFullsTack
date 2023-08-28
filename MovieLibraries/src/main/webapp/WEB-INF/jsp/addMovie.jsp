<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background-color: aqua;">
<div align="center" style="margin-top: 200px">
<h2>Enter Details to Add:</h2>
<p style="color:green">${s}</p>
<form:form action="/addMovie" modelAttribute="movie" method="post">
<table border="1">
<tr>
<td>Movie Id</td><td><form:input type="text" path="id"/></td>
</tr>
<tr>
<td>Movie Name</td><td><form:input type="text" path="movieName"/></td>
</tr>
<tr>
<td>Movie Collection</td><td><form:input type="text" path="movieCollection"/></td>
</tr>
<tr>
<td><button><a href="/home">Home</a></button></td><td><input type="submit" value="Add Movie"/></td>
</tr>
</table>
</form:form>
</div>
</body>
</html>