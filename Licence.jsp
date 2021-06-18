<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="Modern.Driving"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Licence</title>
</head>
<body bgcolor="yellow">
<% String hai=(String)request.getAttribute("info");
if(hai!=null){%>
<h3 style="color:green"><%=hai %></h3>
<%} %>
<div align="center">
<form action="Licence" method="post">
<table cellpadding="4" cellspacing="4">
<tr>
<td>RegNo</td>
<td><input type="text" name="reg" placeholder=""></td>
</tr>
<tr>
<td><center><input type="submit" name="Completed" value="Completed"></center></td>
<td><center><input type="reset" name="CLEAR" value="Reset" ></td></center>
</tr>
</table>
</form>
</div>
</body>
</html>