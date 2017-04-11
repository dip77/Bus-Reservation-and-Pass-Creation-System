<%@page import="com.digimation.gujjubus.bean.ScheduleBean"%>
<%@page import="com.digimation.gujjubus.dao.BusDAO"%>
<%@page import="com.digimation.gujjubus.bean.BusBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Schedule Update</title>
<script src="Gujjubus-javaScript/Bootstrapemin/bootstrap.min.js"></script>
<script src="Gujjubus-javaScript/Dropdown/bootstrap.min.js"></script>

<link rel="stylesheet" href="Gujjubus-css/bootstrap.css" />

<noscript>
	<div style="color: #FF0000">place enable java script</div>
</noscript>
<link rel="icon" href="Gujjubus-photos/logo.ico" /></head>
<body class="col-*-*">
<%@include file="HomePage.jsp" %>
<div class="col-lg-6">
<form action="SeatTypeInsertServlet" method="post">

	 <br />
		 <div class="container">
<div class="row">
 
 

<div class="col-sm-4"><label class="control-label" ><font size="+2"  >Seat Type:</font></label></div>

<div class="col-sm-6">

	<div class="col-md-7"> 
			   <input type="text" size="30" maxlength="7" placeholder="Seat Type" name="txtSeatTypeName" value="${param.txtSeatTypeName}" class="form-control">
			   
			   <font color="red"><b>${msgseattype}</b></font>
	</div>
</div>
<br /><br /><br /><br /><div class="col-lg-5">
					<input type="submit" class="gujju-btn gujju-theme " onclick="Validation();" />
				</div>
				<div class="col-md-4">
					<input type="reset" class="gujju-btn gujju-green " value="Clear" />
				</div>

</div>
<br />
</div>
	</form></div>
	<script>
$(document).ready(function(){
	$("#treeSeat").show();
	$("#seat").addClass("effect");
	$("#addSeat").addClass("effect");
});
</script>
	
</body>
</html>