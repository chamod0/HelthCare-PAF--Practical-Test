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
</head>
<body>
	<div class="contact-clean" style="padding: 132px;">
		 <form  id="form_id" method="post" name="login" action="DoctorAPI">
			<h2 class="text-center pulse animated">Admin Login</h2>
			<div class="form-group">
				<input id="username" class="form-control" type="text"
					name="username" placeholder="Username">
			</div>
			<div class="form-group">
				<input id="password" class="form-control" type="password"
					name="password" placeholder="Password">
			</div>

			<div class="form-group">
				<button id="submit" class="btn btn-primary" type="submit" value="Login"style="margin: 32px; margin-right: 54px; margin-top: 22px; margin-bottom: -30px; margin-left: 32px;">
					Login&nbsp;</button>
			</div>
			<br>
			<h4>
				username : "admin" <br> password : "admin"
			</h4>
		</form>
	</div>
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>


</body>

</html>