<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>User Header</title>

<link rel="stylesheet"
	href="Gujjubus-css/font-awesome-4.5.0/css/font-awesome.min.css" />
<link rel="stylesheet" href="Gujjubus-css/bootstrap.min.css" />
<link rel="stylesheet" href="Gujjubus-css/gujju-blue-theme.css" />
<link rel="stylesheet" href="Gujjubus-javaScript/Jquery/jquery-ui.css" />
<link rel="stylesheet" href="Gujjubus-css/gujjubus.css" />
<link rel="stylesheet"
	href="Gujjubus-css/font-awesome-4.5.0/css/font-awesome.min.css" />
<script src="Gujjubus-javaScript/Jquery/jquery.min.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="Gujjubus-javaScript/model/bootstrap.min.js"></script>
<style>
.home {
	font-size: 24px;
}

.icon {
	font-size: 24px;
}
</style>

<link rel="icon" href="Gujjubus-photos/logo.ico" /></head>

<body>
<%@include file="MainHeader.jsp" %>	 
	 <nav class="navbar navbar-default gujju-theme" role="navigation"
		style="color: white;">

	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target="#userheader">
			<span class="sr-only ">Toggle navigation</span> <i
				class="fa fa-navicon "></i>
		</button>		
		<a class="navbar-brand  gujju-blue" href="index.jsp" id="home"  style="margin-top: 3px;"><i
			class="fa-home fa home">Home</i>
		</a>
	</div>

	<div class="collapse navbar-collapse gujju-card-8" id="userheader">
		<ul class=" nav navbar-nav navbar-right ">
			<li class="gujju-blue header" id="login"><a
				href="UserLoginPage.jsp"><i class="fa fa-unlock-alt icon"></i>&emsp;Login</a>
			</li>
			<li class="gujju-blue header" id="signup"><a href="SignUp.jsp"><i
					class="fa fa-user-plus icon"></i>&emsp;Sign Up</a>
			</li>
			<li class="gujju-blue header" id="contactus"><a
				href="Contact-Us.jsp"><i class="fa-phone fa icon"></i>&emsp;Contact
					Us</a>
			</li>
			<li class="gujju-blue header" id="aboutus"><a href="FaqPage.jsp"><i
					class="fa-user fa icon"></i>&emsp;About Us</a>
			</li>
		</ul>
	</div>
	</nav>
	<script>
		$(document).ready(function() {
			$(".gujju-blue").mouseleave(function() {
				$(this).addClass("gujju-blue");
				$(this).css({
					"transition" : "1s"
				});
				$(this).removeClass("gujju-white gujju-card-8 ");
			});

			$(".gujju-blue").mouseenter(function() {
				$(this).addClass("gujju-white gujju-card-8");
				$(this).removeClass("gujju-blue");
			});
			
			
		});
	</script>
</body>
</html>