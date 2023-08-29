<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="UTF-8">
    <title>Assign Task</title>
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
    <h1 style="color: green;"> Assign Task</h1>
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
    <div class="col-md-4" style="margin-left: 450px;margin-top:100px;">
<form:form action="assignTask" method="post" modelAttribute="m">
    <label for="taskId">Task Id:</label>
    <form:input type="text" id="taskId" name="taskId" required="true" path="taskId" class="form-control form-rounded"/><br>
    <label for="taskId">Employee Id:</label>
    <form:input  type="text" name="empId" path="empId" required="true" class="form-control form-rounded"/><br>
    <input type="submit" class="form-control btn btn-secondary form-rounded" value="assign"/>
</form:form>
    </div>
    </body>
    </html>