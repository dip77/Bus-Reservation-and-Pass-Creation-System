<%@page import="com.digimation.gujjubus.bean.ReservationBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reservation List</title>
<link rel="icon" href="Gujjubus-photos/logo.ico" />
</head>
<body class="col-*-*">
	<%@include file="HomePage.jsp"%>
	<%!ArrayList<ReservationBean> reservationBeansList;%>
	<%reservationBeansList = (ArrayList) request.getAttribute("listofreservation"); %>
	
	<div class="col-lg-6">
		<div class="container">
			<div class="row">
				<div class="col-lg-10">
				<font size="+3" color="red" class=" alert-info"> <%= "<br />"+reservationBeansList .size()+"Records Found" %></font>
	
	<font size="+3" color="red" class=" alert-warning">
		${msgreservation}</font>
	
					<table class="table-hover table gujju-card-4">
						<thead class="gujju-theme">
							<tr>
								<th>First Name</th>
								<th>Middle Name</th>
								<th>Last Name</th>
								<th>Source</th>
								<th>Destination</th>
								<th>No Of Seat</th>
								<th>Journey Date</th>
								<th>Is Cancel</th>
								<th colspan="3">Action</th>
							</tr>
						</thead>
						<tbody>
							<%
							
							for (int i = 0; i < reservationBeansList.size(); i++) {
								ReservationBean reservationBean = reservationBeansList.get(i);
						%>
							<tr>
								<td><%=reservationBean.getFirstName()%></td>
								<td><%=reservationBean.getMiddleName()%></td>
								<td><%=reservationBean.getLastName()%></td>
								<td><%=reservationBean.getSource()%></td>
								<td><%=reservationBean.getDestination()%></td>
								<td><%=reservationBean.getNoOfSeat()%></td>
								<td><%=reservationBean.getJourneyDate()%></td>
								<td><%=reservationBean.getIsCancel()%></td>
								<td><a
									href="ReservationDetailListServlet?id=<%=reservationBean.getReservationId()%>"
									class="btn-default btn "><div class="fa-info fa "
											style="font-size: 30px; color: #2196F3;"></div> </a></td>
								<td><a class="btn-default btn"
									href="ReservationUpdateServlet?id=<%=reservationBean.getReservationId()%>">
										<img src="Gujjubus-photos/edit.ico" height="30" width="30" />
								</a></td>
								<td><a class="btn-default btn"
									href="ReservationDeleteServlet?id=<%=reservationBean.getReservationId()%>">
										<img src="Gujjubus-photos/Recycle Bin.ico" height="30"
										width="30" /> </a></td>
							</tr>
							<%
							}
						%>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<script>
		$(document).ready(function() {
			$("#reservation").show();
			$("#treeReservation").show();
			$("#reservation").addClass("effect");
			$("#listReservation").addClass("effect");
		});
	</script>

</body>
</html>