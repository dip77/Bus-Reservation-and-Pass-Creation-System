<%@page import="java.util.ArrayList"%>
<%@page import="com.digimation.gujjubus.bean.SeatTypeBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script src="Gujjubus-javaScript/Bootstrapemin/bootstrap.min.js"></script>
<script src="Gujjubus-javaScript/Dropdown/bootstrap.min.js"></script>

<link rel="stylesheet" href="Gujjubus-css/bootstrap.css" />

<noscript>
	<div style="color: #FF0000">place enable java script</div>
</noscript>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Seat Type List</title>
<link rel="icon" href="Gujjubus-photos/logo.ico" /></head>
<body class="col-*-*">
<%@include file="HomePage.jsp" %>
	<div class="container">
			<%
				ArrayList<SeatTypeBean> listOfSeatTypeBeans = (ArrayList) request
						.getAttribute("listofseattype");
				if (listOfSeatTypeBeans != null)
			%>
			<font size="+3" color="red"  class=" alert-warning">
			${msgbuscat}
</font>
<font size="+3" color="red"  class=" alert-info">
			<%="<br>" + listOfSeatTypeBeans.size() + " records found"%>
			</font>
			<form>
<div class="col-lg-9">
				<table class="table-hover table gujju-card-4">
					<thead class="gujju-theme">
						<tr>
							<th>Seat Type id</th>
							<th>Seat Type</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<%
							for (int i = 0; i < listOfSeatTypeBeans.size(); i++) {

								SeatTypeBean listOfSeatTypeBean = listOfSeatTypeBeans.get(i);
						%>
						<tr>
							<td><%=listOfSeatTypeBean.getSeatTypeId()%></td>
							<td><%=listOfSeatTypeBean.getSeatType()%></td>
							<td><a
								href="SeatTypeUpdateServlet?id=<%=listOfSeatTypeBean.getSeatTypeId()%>"><img
									src="Gujjubus-photos/edit.ico" height="30" width="30" /> </a> <a
								href="SeatTypeDeleteServlet?id=<%=listOfSeatTypeBean.getSeatTypeId()%>"><img
									src="Gujjubus-photos/Recycle Bin.ico" height="30" width="30" />
							</a></td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
			</form>
		</div>
	</div></div>
	<script>
$(document).ready(function(){
	$("#treeSeat").show();
	$("#seat").addClass("effect");
	$("#listSeat").addClass("effect");
});
</script>

</body>
</html>