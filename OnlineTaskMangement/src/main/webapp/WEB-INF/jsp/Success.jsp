<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Task Added</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
    <br>
    <div align="center">
        <h1 style="color: green;">Online Task Management</h1>
    </div><br><br>
    <div class="menu" align="center">
        <a href="#" class="btn btn-success">Home</a>
        <a href="addTask" class="btn btn-success">Add Task</a>
        <a href="viewTasks" class="btn btn-success">View Task</a>
        <a href="assignTask" class="btn btn-success">Assign Task</a>   
        <a href="ReviewTasks" class="btn btn-success">Review Tasks</a>
        <a href="logout" class="btn btn-success">Log Out</a>
        <hr style="height:2px;border-width:0;color:gray;background-color:gray">
        </div>
<div align="center" style="margin-top: 200px;">
    <h1 style="color: black;">${message}</h1>
</div>
</body>
</html>