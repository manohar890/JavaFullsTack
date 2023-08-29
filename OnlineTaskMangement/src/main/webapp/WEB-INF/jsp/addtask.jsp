<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Task</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<style>
    body {margin:2rem;}

.form-rounded {
border-radius: 1rem;
}
label{
    text-align: left;
}
</style>
</head>
<body>
    <div align="center">
        <h1 style="color: green;">Add Task</h1>
    </div><br><br>
    <div class="menu" align="center">
        <a href="home" class="btn btn-success">Home</a>
        <a href="addTask" class="btn btn-success">Add Task</a>
        <a href="viewTasks" class="btn btn-success">View Task</a>
        <a href="assignTask" class="btn btn-success">Assign Task</a>   
        <a href="ReviewTasks" class="btn btn-success">Review Tasks</a>
        <a href="logout" class="btn btn-success">Log Out</a>
        <hr style="height:2px;border-width:0;color:gray;background-color:gray">
        </div>
<div style="margin-left: 300px;" class="col-md-6">
<form:form action="addTask" method="post" modelAttribute="t" > 
<label for="taskName" class="text-left">Task Name:</label>
<form:input type="text" id="taskName" name="taskName" path="taskName" class="form-control form-rounded"/><br>
<label for="description">Description:</label>
<form:input type="text" name="description" path="description" class="form-control form-rounded"/><br>
<label for="dueDay">Due Days:</label>
<form:input type="text" name="dueDay" path="dueDay" class="form-control form-rounded"/><br>
<input type="submit" value="Add Task" class="btn btn-primary form-control form-rounded">
</form:form> 
</div>
</body>
</html>