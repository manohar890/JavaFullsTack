<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>review Tasks</title>
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
           <h1 style="color: green;"> Review Tasks</h1>
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
           <div align="center">
            <table class="table table-striped" style=" width: 700px;border-color: green" border="2px">
            <tr>
            <th>Task Id</th>
            <th>Employee Id</th>
            <th>Action</th>
            <c:forEach items="${review}" var="m">
                            <tr>
                                <td>${m.taskId}</td>
                                <td>${m.employeeId}</td>
                                <td><a href="action?id=${m.taskId}&action=accept" class="btn btn-success">Accept</a>
                                    <a href="action?id=${m.taskId}&action=reject" class="btn btn-danger">Reject</a>
                                </td>
                            </tr>
                        </c:forEach>
            </table>
            </div>
</body>
</html>