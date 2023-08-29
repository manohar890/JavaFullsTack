<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>register</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<style>
    body {margin:2rem;
        border-width: 2px;
        border-color: black;
    }
h1.demo{

    color:darkgreen;
}
.form-rounded {
border-radius: 1rem;
}
</style>
</head>
<body>
    <div align="center">
        <h1 class="demo">Online Task Management</h1><br><br>
        <hr style="height:2px;border-width:0;color:gray;background-color:gray">
    </div>
   <div align="center">
    <h1>Registered Successfully :</h1>
    <p style="color: brown;">Employee Id : ${id}</p>
    <a href="login" class="btn btn-success form-rounded">Click to Login</a>
   </div>
</body>
</html>