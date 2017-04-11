<%@page import="com.digimation.gujjubus.dao.ScheduleDAO"%>
<%@page import="com.digimation.gujjubus.dao.StationDAO"%>
<%@page import="com.digimation.gujjubus.bean.ReservationDetailBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.digimation.gujjubus.dao.ReservationDAO"%>
<%@page import="com.digimation.gujjubus.bean.ReservationBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="Gujjubus-javaScript/Jquery/jquery.min.js"
	type="text/javascript"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script>
	function Print() {
		window.print();
	}
	document.ready(function() {
		$("a").click(function() {
			$(this).hide();
		});
	});
</script>
<title>Reservation Detail List</title>
<link rel="icon" href="Gujjubus-photos/logo.ico" />
</head>
<body style="text-transform: uppercase; ">
	<%-- <%@ include file="UserHeader.jsp" %> --%>
	<a onclick="Print()" style="margin-left: 300px; color: blue; border-bottom:5px rad; border:5px; cursor: pointer;" id="p">Print
		Ticket</a>
	<%
		ReservationBean reservationBean = (ReservationBean) request.getAttribute("reservationBean");
	ReservationDetailBean reservationDetailBean = (ReservationDetailBean) request.
	getAttribute("reservationDetailBean");
	%>
	<form>
		<div >
			<table border="1" >
				<tr>
					<td>
						<table>
							<tr>
								<td>Source : <%=new StationDAO().getStationListByPK(reservationBean.getSourceId()). getStationName()%></td>
							</tr>
							<tr>
								<td>Destination : <%=new StationDAO().getStationListByPK(reservationBean.getDestinationId()). getStationName()%></td>
							</tr>
							<tr>
								<td>Journey Date: <%=reservationBean.getJourneyDate()%></td>
							</tr>

							<tr>
								<td>Total Amount: <%=reservationBean.getTotalAmount()%></td>
							</tr>
							<tr>
								<td>No Of Seat : <%=reservationBean.getNoOfSeat()%></td>
							</tr>
							<tr>
								<td>Seat No <%
									String seat[]=reservationDetailBean.getSeatNo();
								for (String i :seat) {
								%> <%=i + " , "%> <%
 	}
 %>
								</td>
							</tr>

						</table></td>
				</tr>
			</table>
		</div>
	</form>

</body>
</html>