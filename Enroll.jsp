<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enroll The Candidate</title>
</head>
<body bgcolor="green">
<center><h2>ENROLL THE CANDIDATE</h2></center>
<% String hai=(String)request.getAttribute("info");
if(hai!=null){%>
<h3 style="color:red"><%=hai %></h3>
<%} %>
<div align="center">
<form action="Enroll" method="post">
<table cellpadding="4" cellspacing="4">
<tr>
<td>Name</td>
<td><input type="text" name="name" placeholder=""></td>
</tr>
<tr>
<td>Type</td>
<td><input type="text" name="type" placeholder=""></td>
</tr>
<tr>
<td>Address</td>
<td><input type="file" name="upload" placeholder=""></td>
</tr>
<tr>
<td>Id</td>
<td><input type="file" name="id" placeholder=""></td>
</tr>
<tr>
<td>Date Of Joining</td>
<td><input type="text" name="date" placeholder=""></td>
</tr>
<tr>
<td>Blood Group</td>
<td><input type="text" name="bg" placeholder=""></td>
</tr>
<tr>
<td><center><input type="submit" name="Enroll" value="Enroll"></center></td>
<td><center><input type="reset" name="CLEAR" value="Reset" ></td></center>
</tr>
</table>
</form>
</div>

</body>
</html>