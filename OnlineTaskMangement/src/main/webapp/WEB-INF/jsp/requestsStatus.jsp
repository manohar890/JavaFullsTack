<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="UTF-8">
    <title>Status</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body>
 <div align="center">
    <h1 style="color: green;">Request Status</h1>
</div><br><br>
<div class="menu" align="center">
    <a href="viewAssignTasks" class="btn btn-success">View Tasks</a>
    <a href="status" class="btn btn-success">Status</a>
    <a href="logout" class="btn btn-success">Log Out</a>
    <hr style="height:2px;border-width:0;color:gray;background-color:gray">
    </div>
    <div align="center">
        <table class="table table-striped" style=" width: 700px;border-color: green" border="2px">
        <tr>
        <th>Task Id</th>
        <th>Employee Id</th>
        <th>Status</th>
        <c:forEach items="${req}" var="m">
                        <tr>
                            <td>${m.taskId}</td>
                            <td>${m.employeeId}</td>
                            <td>${m.status}</td>
                        </tr>
                    </c:forEach>
        </table>
        </div>
    </body>
    </html>