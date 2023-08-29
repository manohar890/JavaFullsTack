<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login page</title>
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
<body >
<!-- welcome -->
<div align="center">
    <h1 class="demo">Online Task Management</h1><br><br>
    <hr style="height:2px;border-width:0;color:gray;background-color:gray">
</div>
<div align="center" style=" margin-top: 80px"><h1>Login</h1></div>
<div style="margin-left: 450px;" class="col-md-4">
<form action="Validate" method="Post" >
<label for="username">UserName:</label>
<input type="text" name="username" value="${username}" class="form-control form-rounded" required="true">
<small style="color: red;">${erroruser}
</small><br>
<label for="password">Password:</label>
<input type="password" name="password" class="form-control form-rounded" required="true" value="${password}">
<small style="color: red;">${errorpass}
</small><br>
<input type="Submit" value="Login" class="btn btn-primary form-control form-rounded"><br><br>
<a href="reg"  class="btn btn-success form-control form-rounded">Register</a>
</form>
</div>
</body>
</html>