<%@page import="java.io.InputStream"%>
<%@page import="net.sf.jasperreports.engine.xml.JRXmlLoader"%>
<%@page import="net.sf.jasperreports.engine.design.JasperDesign"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.FileNotFoundException"%>
<%@page import="net.sf.jasperreports.engine.JRException"%>
<%@page import="net.sf.jasperreports.engine.JasperExportManager"%>
<%@page import="net.sf.jasperreports.engine.JasperFillManager"%>
<%@page import="net.sf.jasperreports.engine.JasperPrint"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="net.sf.jasperreports.engine.data.JRBeanCollectionDataSource"%>
<%@page import="net.sf.jasperreports.engine.JasperCompileManager"%>
<%@page import="net.sf.jasperreports.engine.JasperReport"%>
<%@page import="java.io.File"%>
<%@page import="java.util.List"%>
<%@page import="Modern.Driving"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Print</title>
</head>
<body>
<%List<Driving> dri=(List<Driving>)pageContext.getAttribute("tobe", PageContext.APPLICATION_SCOPE); 
out.println(dri);
File fgen=null;
String hai="";
try
{
	InputStream resourceStream = session.getServletContext().getResourceAsStream("/files/report.jrxml");
	JasperDesign jasperDesign = JRXmlLoader.load(resourceStream);
    JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
    JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(dri);
    Map<String, Object> parameters = new HashMap<>();
    parameters.put("createdBy", "karthi");
    parameters.put("createdFor", "Driving School Management");
    System.out.println("Received @ report end before writing "+dri);
    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
    	fgen=new File("driving.pdf");
        JasperExportManager.exportReportToPdfFile(jasperPrint, fgen.getAbsolutePath());
    hai="Report generated @ "+fgen.getAbsolutePath();
    System.out.println("Received @ report end after writing "+hai);
    request.setAttribute("info","Received @ report end after writing "+hai);
    response.sendRedirect("home.jsp");
}
catch(JRException j)
{j.printStackTrace();} 
%>
</body>
</html>