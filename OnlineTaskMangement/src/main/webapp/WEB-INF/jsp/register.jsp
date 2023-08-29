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
    <div style="margin-left: 470px; margin-top: 80px;" class="col-md-4">
        <div align="center" style=" margin-top: 80px"><h1>Register:</h1></div>
        <form:form action="reg" method="post" modelAttribute="emp" > 
        <label for="taskName" class="text-left">UserName:</label>
        <form:input type="text" id="empName" name="taskName" path="empName" class="form-control form-rounded" required="true"/>
        <small style="color: red;">${empname}</small><br>
        <label for="description">Password:</label>
        <form:input type="text" name="pass" path="password" class="form-control form-rounded" required="true"/><br>
        <small style="color: red;">${password}</small>
        <label for="dueDay">Confirm Password:</label>
        <form:input type="text" name="confirm" path="confirmPassword" class="form-control form-rounded" required="true"/>
        <small style="color: red;">${cpass}</small><br>
        <a href="login" class="btn btn-dark  form-rounded" >Back</a>
        <input type="submit" value="register" class="btn btn-success  form-rounded" style="margin-left: 280px;">
        </form:form> 
        </div>
</body>
</html>

