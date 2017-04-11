<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html">
<head>
<title>Admin Header</title>

<noscript>
  <meta HTTP-EQUIV="Refresh" CONTENT="0;URL=JavaScriptErrorPage.html" >
</noscript>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />


<link rel="stylesheet" href="Gujjubus-css/bootstrap.min.css" />
<link rel="stylesheet" href="Gujjubus-css/font-awesome-4.5.0/css/font-awesome.min.css" />
<link rel="stylesheet" href="Gujjubus-css/bootstrap.min.css" />
<link rel="stylesheet" href="Gujjubus-css/gujju-blue-theme.css" />
<link rel="stylesheet" href="Gujjubus-javaScript/Jquery/jquery-ui.css" />
<link rel="stylesheet" href="Gujjubus-css/gujjubus.css" />
<link rel="stylesheet" href="Gujjubus-css/Gujju.css" />
<link rel="stylesheet" href="Gujjubus-css/font-awesome-4.5.0/css/font-awesome.min.css" />
<script src="Gujjubus-javaScript/Jquery/jquery.min.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="Gujjubus-javaScript/model/bootstrap.min.js"></script>
<script src="Gujjubus-javaScript/header/Header.js"></script>
<script src="Gujjubus-javaScript/Jquery/jquery.min.js"
	type="text/javascript"></script>
<link rel="icon" href="Gujjubus-photos/logo.ico" /></head>
<body> 
<%@ include file="MainHeader.jsp" %>	
 	
	<nav class="navbar navbar-default gujju-theme " role="navigation"
		style="color: white;">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target="#example-navbar-collapse">
			<span class="sr-only">Toggle navigation</span> <i
				class="fa fa-navicon"></i>
		</button>
		<a class="navbar-brand btn gujju-blue" href="Admindashboard.jsp" id="home"><i
			class="fa-home fa">Home</i>
		</a>
	</div>
	<div class="collapse navbar-collapse gujju-card-8 gujju-theme"
		id="example-navbar-collapse">


		<ul class="nav navbar-nav  navbar-right  ">
			<li class="gujju-blue  dropdown "><a href="#"
				class="dropdown-toggle" data-toggle="dropdown"> <i
					class="fa-user fa" style="text-transform: uppercase;"> &emsp;${AdminBean.firstName}&nbsp;${AdminBean.lastName}  </i> <b class="caret"></b>
			</a>
				<ul class="dropdown-menu">
					<li><a href="AdminUpdateServlet?id=${AdminBean.adminId}"><i class="fa-edit fa"></i>&emsp;Edit
							Profile</a>
					</li>
					<li><a href="UserChangePassword.jsp"><i class="fa fa-gear"></i>&emsp;
							Change Password</a>
					</li>
					<li class="divider"></li>
					<li><a href="AdminLogoutServlet"><i
							class="fa-sign-in fa"></i>&emsp; Logout</a>
					</li>
				</ul></li>
		</ul>
	</div>
	</nav>
	<script>
	$(document).ready(function() {
		$(".gujju-blue").mouseleave(function() {
			$(this).addClass("gujju-blue");
		    $(this).css({"transition":"1s"});
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