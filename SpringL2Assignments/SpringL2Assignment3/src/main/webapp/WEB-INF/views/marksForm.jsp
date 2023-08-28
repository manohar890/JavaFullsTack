<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>Enter Marks</title>
</head>


<body>
	<div align="center">
		<form:form  action="" method="post" commandName="marks" style="margin-top:200px;">
			<table border="2px" class="table table-striped" style="width: 400px">
				<tr>
					<td colspan="2" align="center"><h2>Enter Marks Of a student</h2></td>
				</tr>
				<tr>
					<td>English :</td>
					<td><form:input path="english" type="number"/></td>
				</tr>
				<tr>
					<td>Mathematics : </td>
					<td><form:input path="mathematics" type="number" /></td>
				</tr>
				<tr>
					<td>Science :</td>
					<td><form:input path="science" type="number"/></td>
				</tr>
				
				
				<tr>
					<td colspan="2" align="center"><input type="submit" value="submit" class="btn btn-success" /></td>
				</tr>
			</table>
		</form:form>
	</div>
	
</body>
</html>