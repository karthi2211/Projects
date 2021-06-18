<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EditEnroll</title>
</head>
<body bgcolor="blue">
<center><h2>Update Your Document Here</h2></center>
<% String hai=(String)request.getAttribute("info");
if(hai!=null){%>
<h3 style="color:green"><%=hai %></h3>
<%} %>
<div align="center">
<form action="Edit" method="post">
<table cellpadding="4" cellspacing="4">
<tr>
<td>RegNo</td>
<td><input type="text" name="reg" placeholder=""></td>
</tr>
<td>Address</td>
<td><input type="file" name="upload" placeholder="Choose File"></td>
</tr>
<tr>
<td>Id</td>
<td><input type="file" name="id" placeholder="Choose File"></td>
</tr>
<tr>
<td><center><input type="submit" name="Enroll" value="Update"></center></td>
<td><center><input type="reset" name="CLEAR" value="Reset" ></td></center>
</tr>
</table>
</form>
</div>
</body>
</html>