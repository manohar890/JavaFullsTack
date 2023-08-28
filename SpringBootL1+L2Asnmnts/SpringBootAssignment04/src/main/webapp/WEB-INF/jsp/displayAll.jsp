<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display All</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
</head>
<body>
<div align="center" class="container">
	<h3 style="color:green">Employee Details</h3>
        <table style="border-color: blue" border="10px" class="table">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Location</th>
            </tr>
            <c:forEach  items="${data}" var="user">
                <tr>
                    <td style="color:red"><c:out value="${user.id}" /></td>
                    <td><c:out value="${user.empName}" /></td>
                    <td><c:out value="${user.empEmail}" /></td>
                    <td><c:out value="${user.empLocation}"/></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>