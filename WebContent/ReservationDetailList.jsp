<%@page import="com.digimation.gujjubus.bean.ReservationDetailBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.digimation.gujjubus.dao.ReservationDAO"%>
<%@page import="com.digimation.gujjubus.bean.ReservationBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>




<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reservation Detail List</title>
<link rel="icon" href="Gujjubus-photos/logo.ico" /></head>
<body>

<a href="ReservationListServlet">Back</a>
<%
ReservationBean reservationBean=(ReservationBean)request.getAttribute("resBean");
%>
<form>
<table border="0">
<tr>
<td>
First Name :  <%= reservationBean.getFirstName() %>
</td>
</tr>
<tr>
<td>
Middle Name :  <%= reservationBean.getMiddleName() %>
</td>
<tr>
<td>
Last Name :  <%= reservationBean.getLastName() %>
</td>
<tr>
<td>
Email :  <%= reservationBean.getEmail() %>
</td>
</tr>
<tr>
<td>
Source :  <%= reservationBean.getSource() %>
</td>
</tr>
<tr>
<td>
Destination :  <%= reservationBean.getDestination() %>
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
Is Cancel:  <%= reservationBean.getIsCancel()%>
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
ArrayList<ReservationDetailBean> listOfreservationDetail= (ArrayList)request.getAttribute("listofresdet"); 

for(int i=0;i<listOfreservationDetail.size();i++)
{
	%>
  <%= listOfreservationDetail.get(i).getSeatNum()+" , "%>
	
	
	<% 
}
%>
</td>
</tr>

<tr>
<td>
Seat Type: 
<%

for(int i=0;i<listOfreservationDetail.size();i++)
{
	%>
  <%= listOfreservationDetail.get(i).getSeatTypeId()+" , "%>

	<% 
}
%>
</td>
</tr>
<tr>
<td>   
Amount : <%= reservationBean.getTotalAmount()%>
</td>	
</tr>
</table>
</form>

</body>
</html>