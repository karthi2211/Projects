<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="pink">
<center><h2>WELCOME TO LOGINPAGE</h2></center>
<% String hai=(String)request.getAttribute("info");
if(hai!=null){%>
<h3 style="color:red"><%=hai %></h3>
<%} %>
<div align="center">
<form action="Login" method="post">
<table cellpadding="4" cellspacing="4">
<tr>
<td>Username for Signin</td>
<td><input type="text" name="user" placeholder="username here"></td>
</tr>
<tr>
<td>Password for Signin</td>
<td><input type="password" name="pass" placeholder="Passoword here"></td>
</tr>
<tr>
<td><input type="submit" name="SIGNIN" value="SignIn"></td>
<td><input type="reset" name="CLEAR" value="Reset" ></td>
</tr>
</table>
</form>
</div>
</body>
</html>