<%@page import="com.digimation.gujjubus.bean.ReservationStatusBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reservation Status List</title>

<link rel="icon" href="Gujjubus-photos/logo.ico" /></head>
<body class="col-*-*">
	<%@include file="HomePage.jsp"%>
	<div class="col-lg-6">
		<%
			ArrayList<ReservationStatusBean> listOfReservationStatusBeans = (ArrayList) request
					.getAttribute("listofreservationstatus");
			if (listOfReservationStatusBeans != null)
		%>
		<font size="+3" color="red"  class=" alert-warning">
		${msgreservationlist}
</font>
<font size="+3" color="red"  class=" alert-info">
		<%="<br>" + listOfReservationStatusBeans.size()
					+ " records found"%>
					</font>


		<form>
			<div class="container">
				<div class="row">
					<div class="col-lg-13">
						<table class="table-hover table gujju-card-4">
							<thead class="gujju-theme">
								<tr>
									<th>Reservation Status id</th>
									<th>Reservation Status</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<%
									for (int i = 0; i < listOfReservationStatusBeans.size(); i++) {

										ReservationStatusBean listOfReservationStatusBean = listOfReservationStatusBeans
												.get(i);
								%>
								<tr>
									<td><%=listOfReservationStatusBean.getReservationStatusId()%>
									</td>
									<td><%=listOfReservationStatusBean.getReservationStatus()%></td>
									<td><a
										href="ReservationStatusUpdateServlet?id=<%=listOfReservationStatusBean.getReservationStatusId()%>"><img
											src="Gujjubus-photos/edit.ico" width="30" height="30" /> </a> <a
										href="ReservationStatusDeleteServlet?id=<%=listOfReservationStatusBean.getReservationStatusId()%>"><img
											src="Gujjubus-photos/Recycle Bin.ico" width="30" height="30" />
									</a>
									</td>
								</tr>
								<%
									}
								%>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>