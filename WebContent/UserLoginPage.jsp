<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>GujjuLogin</title>

<link rel="stylesheet" href="Gujjubus-javaScript/Jquery/jquery-ui.css" />
<link rel="stylesheet" href="Gujjubus-css/gujjubus.css" />
<link rel="stylesheet" href="Gujjubus-css/font-awesome.min.css" />
<script src="Gujjubus-javaScript/Jquery/jquery-ui.js"></script>
<link rel="icon" href="Gujjubus-photos/logo.ico" /></head>
<body>
<%@include file="Header.jsp" %>

<div  >
				<center><font color="red" size="+2" style="text-transform: capitalize;">	${msglogin}
					${msguser}</font></center>
				<form action="LoginController" method="post"  >
					<div class="container "  >
					<div class=" col-lg-7 gujju-card-12" style="margin-left:320px; margin-top: 100px;  margin-bottom: 90px;">
					<div class="row">

						<h3 style="text-align: center;" >
							Login Here <i class="fa-lock fa" style="color: #0099FF" ></i>
						</h3>
						<div class="col-lg-16">
							<label class="col-lg-3">Email</label>
							<div class="col-md-9">
								<input type="email" maxlength="30" name="txtemail"
									placeholder="Example@gujjubus.com" value="${param.txtemail}"
									class="form-control" />
							<font color="red">		${username}</font>
							</div>
						</div>
						<br /> <br />
						<div class="col-lg-16">
							<label class="col-lg-3">Password</label>
							<div class="col-md-9">
								<input type="password" maxlength="20" name="pwdpassword" placeholder="Password"
									class="form-control" />
														<font color="red">	${password}</font>
							</div>
						
						<br />  <br />
						</div>
						<div class="gujju-col m10">
							<input type="submit" name="txtemail" value="Log In" style="margin-left: 190px"
								class="  gujju-blockquote gujju-theme gujju-btn  "   />
						<a href="ForgotPassword.jsp">Forgot password?</a>
								
						</div>
						
						<div class="gujju-col m7">
						</div>
							<br /> <br />
					</div>	
				</div></div>
				</form>
			</div>
			
			<%@include 	file="Footer.jsp"%> 
			<script>
			$(document).ready(function() {
				$("#login").removeClass("gujju-blue gujju-card-24");
				$("#login").addClass("gujju-theme-d2 gujju-card-24");
				 
			});
			</script>
</body>
</html>
