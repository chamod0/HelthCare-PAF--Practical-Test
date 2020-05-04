<%@ page import="com.Doctor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%
 //Insert Doctor----------------------------------
if (request.getParameter("name") != null)
 {
	Doctor DoctorObj = new Doctor();
 String stsMsg = DoctorObj.insertDoctor(request.getParameter("name"),
			request.getParameter("Tel"),
			request.getParameter("Specialization"),
			request.getParameter("Hospital"),
			request.getParameter("Email"),
			request.getParameter("password"));
 
 
 session.setAttribute("statusMsg", stsMsg);
 
 }
//Delete Doctor----------------------------------
if (request.getParameter("DoctorID") != null)
{
	Doctor DoctorObj = new Doctor();
	String stsMsg = DoctorObj.deleteDoctor(request.getParameter("DoctorID"));
session.setAttribute("statusMsg", stsMsg);
}
%>

<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>Doctor Management</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
  <script src="js/script.min.js"></script>

</head>
<body>
<h1>Doctor Management</h1>
<form method="post" action="DoctorAdmin.jsp">
 
 		name: <input name="name" type="text"><br>
 		Tel: <input name="Tel" type="text"><br>
		Specialization:<input name="Specialization" type="text"><br>
		Hospital: <input name="Hospital" type="text"><br>
		Email: <input name="Email" type="text"><br> 
		password: <input name="password" type="text"><br>  
		
		 <input name="btnSubmit" type="submit" value="Save" class="btn btn-primary">
</form>
<div class="alert alert-success">
 <% out.print(session.getAttribute("statusMsg"));%>
</div>
<br>
<%
Doctor DoctorObj = new Doctor();
 out.print(DoctorObj.readDoctor());
%>
</body>
</html>
