<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Services</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body >
<div align="center">
<h1 style="color: green;">${name}</h1>
</div>
<div>
<h6 Style="color:blue;margin-left: 300px;">Hdfc Bank Services:</h6>
</div>
 <div align="center">
<table class="table table-striped" style=" width: 700px;border-color: green" border="2px">
<tr>
<th>S.no</th>
<th>Branch Address</th>
<%int i=0; %>
<c:forEach items="${services}" var="m">

                <tr>
                    <td><%= ++i %></td>
                    <td>${m}</td>
                    
                </tr>
            </c:forEach>
</table>

</div>
</body>
</html>