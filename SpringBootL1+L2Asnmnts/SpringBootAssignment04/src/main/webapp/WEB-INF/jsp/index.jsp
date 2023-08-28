<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enter details</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>
</head>
<body>
<div class="container" style="margin-top: 200px">

	<form:form method="post"  modelAttribute="emp" style="border-color: lime;border:100px;margin-left:300px;margin-right:200px;" >
	<h5 style="color:green">${S}</h5>
		<div class=row>
				<label  style="color:blue;">Employee Id:</label>
				<form:input type="text" name="name" id="1" class="form-control" path="id" required="required"/>
				<br>
				<label  style="color:blue;">Employee Name</label>
				<form:input type="text" name="name" id="1" class="form-control" path="EmpName" required="required"/>
				<br>
				<label style="color:blue;">Employee Email:</label>
				<br>
				<form:input type="email" name="email" id="2" class="form-control" path="EmpEmail"/>
				<br>
				<label  style="color:blue;">Employee Location:</label>
				<br>
				<form:input type="text" name="password" id="3" class="form-control" path="EmpLocation"/>
				<br>
				<input type="submit" value="Add" class="btn btn-success">
		</div>
	</form:form>
</div>
</body>
</html>