<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">

<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
  <script src="assets/js/script.min.js"></script>
<script src="Componets/jquery-3.5.0.min.js"></script>
<script src="Componets/doctor.js"></script>
<link rel="stylesheet" href="assets/css/Contact-Form-Clean.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" />
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.12.0/css/all.css">
<title>Admin Panel</title>
</head>
<body>


<% 
response.setHeader("Cache-Control", "no-cache, no-store,must-revalidate");
if(session.getAttribute("username")== null){
	
	
	response.sendRedirect("AdminLogin.jsp");
} %>
<nav aria-label="breadcrumb">
  <ol class="breadcrumb">
    <li class="breadcrumb-item"><a href="AdminPanel.jsp">Admin panel</a></li>

     <li class="breadcrumb-item" align="right" ><a align="right"  href="logout.jsp">logout</a></li>
    
    
  </ol>
</nav>
<h1 align="center"  style="padding: 132px;">Admin  Panel</h1>

<div class="container">
    <div class="row">
    <div class="col-md-3">
      <div class="card-counter primary">
        <i class="fa fa-users"></i>
        <span class="count-numbers">User</span>
        <span class="count-name"></span>
      </div>
    </div>

    <div class="col-md-3">
    <a href = "DoctorAdmin.jsp"> 
      <div class="card-counter danger">
        <i class="fas fa-user-nurse m-auto text-primary"></i>
        <span class="count-numbers">Doctor</span>
        <span class="count-name"></span>
      </div>
      </a>
    </div>

    <div class="col-md-3">
      <div class="card-counter success">
        <i class="fas fa-hospital-alt m-auto text-primary"></i>
        <span class="count-numbers">Hospital</span>
        <span class="count-name"></span>
      </div>
    </div>

    <div class="col-md-3">
      <div class="card-counter info">
        <i class="fa fa-database"></i>
        <span class="count-numbers">Payment</span>
        <span class="count-name"></span>
      </div>
    </div>
  </div>
</div>
</body>
</html>