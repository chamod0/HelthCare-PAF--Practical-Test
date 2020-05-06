<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
  <script src="assets/js/script.min.js"></script>
<script src="Componets/jquery-3.5.0.min.js"></script>

<link rel="stylesheet" href="assets/css/Contact-Form-Clean.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" />
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.12.0/css/all.css">

<script src="Componets/doctor.js"></script>
<title>Doctor Profile</title>
</head>
<body>

<% 
//session check
response.setHeader("Cache-Control", "no-cache, no-store,must-revalidate");
if(session.getAttribute("DoUsername")== null){
	
	
	response.sendRedirect("DoctorLogin.jsp");
} %>
<nav aria-label="breadcrumb">
  <ol class="breadcrumb">
    <li class="breadcrumb-item"><a href="index">Home</a></li>
	<li class="breadcrumb-item">Doctor Profile</li>
     <li class="breadcrumb-item" align="right" ><a align="right"  href="logout.jsp">logout</a></li>
    
    
  </ol>
</nav>

<h1 align="center"  style="padding: 20px;">Doctor Profile </h1>
<div class="container">
	<div class="row">
		<div class="col-6">
<div class="form-group">
 <h3>Hi ${DoUsername}</h3> 
 <form id="DoctorForm" name="DoctorForm" method="post" action="DoctorRegister.jsp">
 <h5>${details}</h5>
 

 
 </form>
 
 <div id="alertSuccess" class="alert alert-success">

 
 </div>
<div id="alertError" class="alert alert-danger">
</div>
 </div>
 </div>
 </div>
 </div>

</body>
</html>