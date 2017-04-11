<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="javax.xml.crypto.Data"%>
<%@page import="com.digimation.gujjubus.dao.PassDetailDAO"%>
<%@page import="com.digimation.gujjubus.dao.PassDAO"%>
<%@page import="com.digimation.gujjubus.dao.ReservationDAO"%>
<%@page import="com.digimation.gujjubus.dao.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>AdminDashboard</title>
<link rel="stylesheet	" href="Gujjubus-css/gujjubus.css" />
<link rel="stylesheet" href="Gujjubus-css/Gujju.css" />
<link rel="stylesheet" href="Gujjubus-css/gujju-theme-theme.css" />
<link rel="stylesheet"
	href="Gujjubus-css/font-awesome-4.5.0/css/font-awesome.min.css" />
<script src="Gujjubus-javaScript/model/bootstrap.min.js"></script>

<script src="Gujjubus-javaScript/header/Header.js"></script>

<script type="text/javascript"
	src="Gujjubus-javaScript/model/bootstrap.min.js"></script>

<script src="Gujjubus-javaScript/Jquery/jquery.min.js"
	type="text/javascript"></script>

<link rel="icon" href="Gujjubus-photos/logo.ico" />
</head>
<body>
	<%@include file="HomePage.jsp"%>
	<div class="container">
		<div class="gujju-row-padding gujju-col m8 gujju-margin-top"
			align="center">
			<div class="col-xs-12">

				<div class="panel panel-default gujju-card-16 ">
					<div class="panel-body gujju-theme-d2" style="font-weight: bold;">Total</div>
				</div>
			</div>

			<div class="col-xs-4">

				<div class="panel panel-default gujju-card-16 ">
					<div class="panel-heading ">
						<i class="fa-user-plus fa" style="font-size: 40px;">&emsp;&emsp;
							<%=new UserDAO().getUserList().size()%></i>
					</div>
					<div class="panel-body gujju-theme-d2" style="font-weight: bold;">Registration</div>
				</div>
			</div>

			<div class="col-xs-4">
				<div class="panel panel-default   gujju-card-16 ">
					<div class="panel-heading  ">
						<i class="fa-ticket fa" style="font-size: 40px;">&emsp;&emsp;
							<%=new ReservationDAO().getReservationList().size()%> </i>
					</div>
					<div class="panel-body gujju-theme-d2" style="font-weight: bold;">Reservation</div>
				</div>
			</div>


			<div class="col-xs-4">
				<div class="panel panel-default     gujju-card-16 ">
					<div class="panel-heading ">
						<i class="fa fa-newspaper-o" style="font-size: 40px;">&emsp;&emsp;
							<%=new PassDAO().getPassList().size()%> </i>
					</div>
					<div class="panel-body gujju-theme-d2" style="font-weight: bold;">Pass
						Generated</div>
				</div>
			</div>
			<div class="col-xs-12">

				<div class="panel panel-default gujju-card-16 ">
					<div class="panel-body gujju-theme-d3" style="font-weight: bold;"
						id="date">
						<script type="text/javascript">
							document.getElementById('date').innerHTML = "Today : "
									+ new Date().getDate()
									+ "/"
									+ (new Date().getMonth() + 1)
									+ "/"
									+ new Date().getFullYear();
						</script>
					</div>
				</div>
			</div>

			<div class="col-xs-4">
				<div class="panel panel-default     gujju-card-16 ">
					<div class="panel-heading ">
						<i class="fa fa-ticket" style="font-size: 40px;">&emsp;&emsp;
							<%=new UserDAO().getRegularUserList().size()%> </i>
					</div>
					<div class="panel-body gujju-theme-d2" style="font-weight: bold;">Registartion
						Done</div>
				</div>
			</div>

			<div class="col-xs-4">
				<div class="panel panel-default     gujju-card-16 ">
					<div class="panel-heading ">
						<i class="fa fa-ticket" style="font-size: 40px;">&emsp;&emsp;
							<%=new ReservationDAO().getRegularReservationList().size()%> </i>
					</div>
					<div class="panel-body gujju-theme-d2" style="font-weight: bold;">
						Reservation Done</div>
				</div>
			</div>


			<div class="col-xs-4">
				<div class="panel panel-default     gujju-card-16 ">
					<div class="panel-heading ">
						<i class="fa fa-newspaper-o" style="font-size: 40px;">&emsp;&emsp;
							<%=new PassDetailDAO().getRegularPassDetailList().size()%> </i>
					</div>
					<div class="panel-body gujju-theme-d2" style="font-weight: bold;">Pass
						Generated</div>
				</div>
			</div>



		</div>
	</div>
	<script>
		$(document).ready(function() {
			$("#desh").addClass("effect");
		});
	</script>
<%@include file="Footer.jsp" %>
</body>
</html>