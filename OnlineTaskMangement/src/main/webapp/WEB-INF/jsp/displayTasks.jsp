
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Tasks</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body >
    <div align="center" >
        <h1 style="color: green;">View Tasks</h1>
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
<h6 Style="color:blue;margin-left: 370px;">Viewing All Tasks:</h6>
</div>
 <div align="center">
<table class="table table-striped" style=" width: 700px;border-color: green" border="2px">
<tr>
<th>Task Id</th>
<th>Task Name</th>
<th>Task Description</th>
<th>Due Days</th>
<c:forEach items="${tasks}" var="m">
                <tr>
                    <td>${m.taskId}</td>
                    <td>${m.taskName}</td>
                    <td>${m.description}</td>
                    <td>${m.dueDay}</td>
                     <td><a href="confirmdelete?id=${m.taskId}"  class="btn btn-warning">Delete</a></td> 
                </tr>
            </c:forEach>
</table>
</div>
<script language="javascript" type="text/javascript">
    function confirmation(id){
        alert("Are you sure to delete task?" + id);
    }
</script>
</body>
</html>