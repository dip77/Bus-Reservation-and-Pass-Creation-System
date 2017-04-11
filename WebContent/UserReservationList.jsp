<%@page import="java.io.FileNotFoundException"%>
<%@page import="com.sun.mail.iap.Response"%>
<%@page import="java.io.File"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="com.google.zxing.qrcode.encoder.QRCode"%>
<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="com.digimation.gujjubus.bean.ScheduleDetailBean"%>
<%@page import="com.digimation.gujjubus.bean.ScheduleBean"%>
<%@page import="com.digimation.gujjubus.bean.ReservationDetailBean"%>
<%@page import="com.digimation.gujjubus.bean.ReservationBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirm Ticket</title>
<link rel="icon" href="Gujjubus-photos/logo.ico" /></head>
<body>
<%@include file="UserHeader.jsp"%>
<%
ReservationBean reservationBean=(ReservationBean)session.getAttribute("reservationBean");
ReservationDetailBean reservationDetailBean=(ReservationDetailBean)
session.getAttribute("reservationDetailBean");
ScheduleDetailBean scheduleBean=(ScheduleDetailBean)session.getAttribute("scheduleDetailBean");
%>

<form action="UserReservationConfirmServlet" method="post">

<div class="col-lg-3  gujju-card-4" align="center">
<table style="text-align: center; text-transform: uppercase;" >
<tr>
<td>
Source :  <%= scheduleBean.getSource() %>
</td>
</tr>
<tr>
<td>
Destination :  <%= scheduleBean.getDestination() %>
</td>
</tr>

<tr>
<td>
Journey Date:  <%= reservationBean.getJourneyDate()%>
</td>
</tr>

<tr>
<td>
Total Amount:  <%= reservationBean.getTotalAmount()%>
</td>
</tr>


<tr>
<td>
No Of Seat :  <%= reservationBean.getNoOfSeat()%>
</td>
</tr>
<tr>
<td>
Seat No
<%
String[] listOfreservationDetail= reservationDetailBean.getSeatNo(); 

for(int i=0;i<listOfreservationDetail.length;i++)
{
	%>
  <%= listOfreservationDetail[i]+" , "%>
	
	
	<% 
}
%>	
</td>
</tr>

<tr>
 </tr>
<tr>
<td>   
Amount : <%= reservationBean.getTotalAmount()%>
</td>	
</tr>
<tr>
<td colspan="1" style="text-align: center;">

<input type="submit" value="confirm" class="gujju-blue gujju-btn" />
</td>
</tr>
</table>
</div>
</form>
</body>
</html>