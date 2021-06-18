<%@page import="Modern.Driving"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%List<Driving> area=(List<Driving>)request.getAttribute("all");%>
<%String D=(String)request.getAttribute("done");
if(D!=null){%>
<%=D%>
<%} %>
<div align="center">
<table border="4" cellpadding="4" %="4">
<tr>
<th>Registration Number</th><th>Name</th>
<th>Type</th><th>DataofJoin</th>
<th>Address</th><th>ID</th>
<th>BloodGroup</th></tr>
<%for(Driving yet:area){%>
<tr>
<td><%=yet.getRegno()%></td><td><%=yet.getName()%></td>
<td><%=yet.getType() %></td><td><%=yet.getDateofjoin()%></td>
<td><%=yet.getAddress()%></td><td><%=yet.getId()%></td>
<td><%=yet.getBgroup() %></td>
<td>
<ol type="A">
<li><a href="Delete?single=<%=yet.getRegno()%>">Delete</a></li>
</ol>
</td>
</tr>
<%} %>
</table>

</body>
</html>