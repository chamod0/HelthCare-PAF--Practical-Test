<%@ page import="com.Doctor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%/*
 //Insert Doctor----------------------------------
if (request.getParameter("name") != null){
	
	Doctor DoctorObj = new Doctor();
	String stsMsg ="";
	
	
	
	if (request.getParameter("hidDoctorIDSave") == "") {
		
		 stsMsg = DoctorObj.insertDoctor(request.getParameter("name"),
					request.getParameter("Tel"),
					request.getParameter("Specialization"),
					request.getParameter("Hospital"),
					request.getParameter("Email"),
					request.getParameter("password"));
		 
	}else{
		
		 stsMsg = DoctorObj.updateDoctor(request.getParameter("hidDoctorIDSave"),
				 	request.getParameter("name"),
					request.getParameter("Tel"),
					request.getParameter("Specialization"),
					request.getParameter("Hospital"),
					request.getParameter("Email"),
					request.getParameter("password"));
		
		
	}
	
	
 
 
 session.setAttribute("statusMsg", stsMsg);
 
 }
//Delete-----------------------------
if (request.getParameter("hidDoIDDelete") != null)
{
	Doctor DoctorObj = new Doctor();
String stsMsg =DoctorObj.deleteDoctor(request.getParameter("hidDoIDDelete"));
session.setAttribute("statusMsg", stsMsg);
} */

%>

<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
 <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>Doctor Management</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
  <script src="js/script.min.js"></script>
<script src="Componets/jquery-3.5.0.min.js"></script>
<script src="Componets/doctor.js"></script>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-6">

<h1>Doctor Management</h1>
<form id="DoctorForm" name="DoctorForm" method="post"  action="DoctorAdmin.jsp">
 						<input id ="id" name="id" type="text" class="form-control form-control-sm" ><br>
 		Name: 			<input id ="name" name="name" type="text" class="form-control form-control-sm" ><br>
 		Tel: 			<input id = "Tel"  name="Tel" type="text" class="form-control form-control-sm"><br>
		Specialization:	<input id="Specialization" name="Specialization" type="text" class="form-control form-control-sm"><br>
		Hospital: 		<input id = "Hospital" name="Hospital" type="text" class="form-control form-control-sm"><br>
		Email: 			<input id = "Email" name="Email" type="text" class="form-control form-control-sm"><br> 
		password: 		<input id="password" name="password" type="text" class="form-control form-control-sm"><br>  
						<input id="btnSave" name="btnSave" type="button" value="Save"class="btn btn-primary">
						 <input type="hidden" id="hidDoctorIDSave" name="hidDoctorIDSave" value="">
</form>
<div id="alertSuccess" class="alert alert-success"></div>
<div id="alertError" class="alert alert-danger"></div>

<br>
<div id="divDoGrid">

<%
	Doctor DoctorObj = new Doctor();
	 out.print(DoctorObj.readDoctor());
%>
	</div>
		</div>
	 </div>
</div>
</body>
</html>
