<%@page import="com.digimation.gujjubus.bean.ReservationBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reservation List</title>





<noscript>
	<div style="color: #FF0000">place enable java script</div>
</noscript>
<link rel="icon" href="Gujjubus-photos/logo.ico" /></head>
<body class="col-*-*">
<%@include file="HomePage.jsp" %>
<div class="col-lg-6">
	<br />
	<br />
	<form action="ReservationStatusInsertServlet" method="post">
		<div class="container">
			<div class="row">
				<div class="col-sm-4">
					<label class="control-label"><font size="+2"
						 >Reservation Status:</font>
					</label>
				</div>

				<div class="col-sm-6">
					<div class="col-md-7">
						<input type="text" size="30" maxlength="7"
							placeholder="Reservation Status" name="txtReservationStatusName"
							class="form-control"
							value="${param.txtReservationStatusValidateName}">
							
							<font color="red"><b>${msgreservationstatustype}</b></font>
					</div>
				</div>
				<br />
				<br />
				<br />
				<br />
				<div class="col-sm-3">
					<input type="submit" value="Add Bus" class="btn btn-primary" />
				</div>

				<div class="col-sm-6">
					<input type="reset" value="Clear Field" class="btn btn-success" />
				</div>
			</div>
			<br />
		</div>
	</form></div>
</body>
</html>