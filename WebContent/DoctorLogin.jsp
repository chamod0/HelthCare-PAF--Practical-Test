<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Doctorlogin</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/Contact-Form-Clean.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
    <link rel="stylesheet" href="assets/css/styles.css">
</head>

<body>
    <div class="contact-clean" style="padding: 132px;">
        <form  id="form_id" method="post" name="login">
            <h2 class="text-center pulse animated">Doctor Login</h2>
            <div class="form-group"><input id = "username"class="form-control" type="text" name="username" placeholder="Username"></div>
            <div class="form-group"><input id = "password"class="form-control" type="password" name="password" placeholder="Password"></div>
          
            <div class="form-group"><button id ="submit" class="btn btn-primary" type="submit" onclick="return check(this.form)" value="Login" style="margin: 32px;margin-right: 54px;margin-top: 22px;margin-bottom: -30px;margin-left: 32px;">Login&nbsp;</button>
       		<a  class="btn btn-primary" href = "DoctorRegister.jsp" style="margin: 32px;margin-right: 39px;margin-top: -14px;margin-bottom: 49px;margin-left: 261px;">Register </a>
        </form>
    </div>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    
  <script language="javascript">
function check(form)/*function to check userid & password*/
{
 /*the following code checkes whether the entered userid and password are matching*/
 if(form.username.value == "a" && form.password.value == "a")
  {
	 window.open('DoctorAdmin.jsp')
	 
	 return false;
   // window.open('DoctorAdmin.jsp','_cloc')/*opens the target page while Id & password matches*/
  }
 else
 {
   alert("Error Password or Username")/*displays error message*/
  }
}
</script>
</body>

</html>