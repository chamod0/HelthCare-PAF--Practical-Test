<%@ page import="com.Doctor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>Doctorlogin</title>
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/Contact-Form-Clean.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
<link rel="stylesheet" href="assets/css/styles.css">
<script src="assets/js/script.min.js"></script>
<script src="Componets/jquery-3.5.0.min.js"></script>
<script src="Componets/doctor.js"></script>
</head>
</head>

<body>
	<div class="contact-clean" style="padding: 132px;">
	
		<h1 align="center">Doctor Register</h1>

		<div class="form-group">

			<form id="DoctorForm" name="DoctorForm" method="post" action="DoctorRegister.jsp">
				
				<div id="alertSuccess" class="alert alert-success"></div>
				
				<div id="alertError" class="alert alert-danger"></div>

				Name: 			<input id="name" name="name" type="text" class="form-control form-control-sm"><br>
				
				Tel: 			<input id="Tel" name="Tel" type="text"class="form-control form-control-sm"><br>
				
				Specialization: <input id="Specialization" name="Specialization" type="text" class="form-control form-control-sm"><br>
				
				Hospital: 		<input id="Hospital" name="Hospital" type="text" class="form-control form-control-sm"><br>
				
				Email: 			<input id="Email" name="Email" type="text" class="form-control form-control-sm"><br> 
				
				password:   	<input id="password" name="password" type="text" class="form-control form-control-sm"><br> 
					
								<input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary"> 
							
								<input type="hidden" id="hidDoctorIDSave" name="hidDoctorIDSave" value="">
							
							<a class="btn btn-primary" href="DoctorLogin.jsp">Cancel </a>
			</form>

		</div>


	</div>
	<script src="assets/js/jquery.min.js"></script>
	
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>


</body>

</html>