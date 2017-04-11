<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.digimation.gujjubus.dao.UserDAO"%>
<%@page import="com.digimation.gujjubus.bean.ReservationBean"%>
<%@page import="com.digimation.gujjubus.bean.UserBean"%>
<%@page import="com.digimation.gujjubus.dao.BusDAO"%>
<%@page import="com.digimation.gujjubus.bean.BusBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.digimation.gujjubus.dao.RouteDAO"%>
<%@page import="com.digimation.gujjubus.bean.RouteBean"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Registration.jsp User</title>
<noscript>
	<div style="color: #FF0000">place enable java script</div>
</noscript>
<script>
	function take() {
		var a = document.createAttribute("min");
		var now = new Date();
	 a.value = now.getFullYear() + '-' + (now.getMonth() + 1) + '-'	+ now.getDate();
		document.getElementById("date1").setAttributeNode(a);
	}
</script>
<link rel="icon" href="Gujjubus-photos/logo.ico" /></head>
<body class="col-*-*" onload="take()">	
<%@include file="UserHeader.jsp"%>
	<div class="col-lg-6">
		<%!ArrayList<RouteBean> routeBeansList;
	ArrayList<BusBean> busBeansList;%>
		<form action="UserReservationInsertServlet" method="post" >
			<br />
			<div class="col-lg-6">
				<div class="container">
					<div class="row">
						<div class="col-lg-8">
							<div class="col-sm-3">
								<font size="+1">No of Seat:</font>
							</div>
							<div class="col-md-9">
								<input type="number" class="form-control text-capitalize"
									min="1" max="5" maxlength="1" placeholder="No of Seat"
									name="noOfSeat" /> <font color="red"><b>${msgseat}</b></font>
							</div>
						</div>
					</div>

					<br />


					<div class="row">
						<div class="col-lg-8">
							<div class="col-sm-3">
								<font size="+1">Journey Date:</font>
							</div>
							<div class="col-md-9">
								<input type="date" class="form-control" id="date1" name="resDate"
									onfocus="take();" placeholder="yyyy-mm-dd"
									value="${param.resDate}" /><font color="red"><b>${msgdate}</b></font>
							</div>
						</div>

					</div>

					<br />
					
					<div class="row">
						<div class="col-lg-8">
							<div class="col-lg-5">
					<input type="submit" class="gujju-btn gujju-theme " onclick="Validation();" />
				</div>
				<div class="col-md-4">
					<input type="reset" class="gujju-btn gujju-green " value="Clear" />
				</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	<script>
		$(document).ready(function() {
			$("#reservation").show();
			$("#treeReservation").show();
			$("#reservation").addClass("effect");
			$("#addReservation").addClass("effect");
		});
	</script>

</body>
</html>
