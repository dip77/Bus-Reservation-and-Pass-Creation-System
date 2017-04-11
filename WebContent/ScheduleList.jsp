<%@page import="com.digimation.gujjubus.bean.ScheduleBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Schedule List</title> 
<link rel="icon" href="Gujjubus-photos/logo.ico" /></head>

<body class="col-*-*">
<%@include file="HomePage.jsp" %>
	<%
		ArrayList<ScheduleBean> listOfScheduleBeans = (ArrayList) request
				.getAttribute("listofschedule");
		if (listOfScheduleBeans != null)
	%>
	<font size="+3" color="red"  class=" alert-warning">
	${msgbuscat}
</font>
<font size="+3" color="red"  class=" alert-info">
	<%="<br>" + listOfScheduleBeans.size() + " records found"%>
	</font>
	<form>
		<div class="container">
			<div class="row">
<div class="col-lg-9">
				<table class="table-hover table gujju-card-4">
					<thead class="gujju-theme">
						<tr>
							<th>Bus No</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<%
							for (int i = 0; i < listOfScheduleBeans.size(); i++) {

								ScheduleBean listOfScheduleBean = listOfScheduleBeans.get(i);
						%>
						<tr>
							<td><%=listOfScheduleBean.getBusNo()%></td>
							<td><a
								href="ScheduleUpdateServlet?id=<%=listOfScheduleBean.getScheduleId()%>"><img
									src="Gujjubus-photos/edit.ico" height="30" width="30" /> </a> <a
								href="ScheduleDeleteServlet?id=<%=listOfScheduleBean.getScheduleId()%>"><img
									src="Gujjubus-photos/Recycle Bin.ico" height="30" width="30" />
							</a>
							</td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
	</div></div></div></form>
</body>
</html>