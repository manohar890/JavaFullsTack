<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="UTF-8">
    <title>Confirm Delete</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body>
 <div align="center">
    <h1 style="color: green;">Manager Home</h1>
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
    <div align="center" class="col-md-6" style="margin-top:100px;margin-left: 350px;">
        <form >
            <p>Confirm to delete Task:</p>
            <a href="viewTasks" class="btn btn-dark" >Cancel</a>
            <a href="delete?id=${id}" class="btn btn-danger" >Delete</a>
        </form>
    </div>
    </body>
    </html>