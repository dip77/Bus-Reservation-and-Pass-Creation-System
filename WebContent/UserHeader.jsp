
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
	<%@ include file="MainHeader.jsp" %>
	<nav class="navbar navbar-default gujju-theme" role="navigation"
		style="color: white;">

	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target="#userheader">
			<span class="sr-only ">Toggle navigation</span> <i
				class="fa fa-navicon "></i>
		</button>
		<a class="navbar-brand  gujju-blue" href="UserHomePage.jsp" id="home"
			style="margin-top: 10px;"><i class="fa-home fa home">Home</i>
		</a>
	</div>

	<div class="collapse navbar-collapse gujju-card-8" id="userheader">
		<ul class="nav navbar-nav ">
			<li class="gujju-blue header" style="padding-top: 5px;"
				id="yourbooking"><a href="ShowReservationServlet"><i
					class="fa-ticket fa icon"></i>&emsp;Your Booking</a>
			</li>

			<li class="gujju-blue  dropdown"><a href="#"
				class="header dropdown-toggle" id="pass" data-toggle="dropdown">
					<i class="fa-credit-card fa icon" style="margin-top: 8px;"></i>&emsp;Pass
					<b class="caret"></b> </a>

				<ul class="dropdown-menu">
					<li><a href="UserPassInsert.jsp"><i
							class="fa-user-plus fa"></i>&emsp;New Pass</a>
					</li>

					<li class="divider"></li>
					<li><a href="RenewPass.jsp"><i
							class="fa-credit-card-alt fa"></i>&emsp; Renew Pass</a>
					</li>
					 
					
				</ul></li>
			<li class="gujju-blue header" style="padding-top: 5px;" id="aboutus"><a
				href="UserFaqPage.jsp"><i class="fa-group fa icon"></i>About Us</a>
			</li>
			<li class="gujju-blue header" style="padding-top: 5px;"
				id="contactus"><a href="UserContact-Us.jsp"><i class="fa-phone fa icon"></i>&emsp;Contact
					Us</a>
			</li>
		</ul>
		<ul class="nav navbar-nav navbar-right">

			<li class="nav navbar-nav btn navbar-right gujju-blue  dropdown">

				<a href="#" class="dropdown-toggle" data-toggle="dropdown"> <i
					class="fa-user fa text-uppercase"> &emsp;${userBean.firstName}&nbsp;${userBean.lastName} </i> <b class="caret"></b>
			</a>
				<ul class="dropdown-menu">
					<li><a href="UserEdit.jsp"><i class="fa-edit fa"></i>&emsp;Edit
							Profile</a>
					</li>
					<li><a href="UserChangePassword.jsp"><i class="fa fa-gear"></i>&emsp;
							Change Password</a>
					</li>
					<li class="divider"></li>
					<li><a href="UserLogoutController"><i
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