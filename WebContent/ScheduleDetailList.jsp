<%@page import="com.digimation.gujjubus.util.ValidateUtils"%>
<%@page import="com.digimation.gujjubus.bean.ScheduleDetailBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Schedule Detail</title>

<link rel="stylesheet" href="Gujjubus-css/font-awesome.min.css" />



<link rel="icon" href="Gujjubus-photos/logo.ico" /></head>
<body class="col-*-*">
	<%@include file="HomePage.jsp"%>

	<%ArrayList<ScheduleDetailBean> scheduleDetailBeanList = (ArrayList) request
					.getAttribute("listofscheduledetail");
		%>
		<div class="container">
		<div class="row">
		
	<div class="col-lg-9">
	
	<font size="+3" color="red" class=" alert-warning">
		${msgscheduledetail}</font>
	<font size="+3" color="red" class=" alert-info"><%=scheduleDetailBeanList.size()+" Records Found" %> </font>
			<table class="table-responsive table-hover table gujju-card-4">
	
				<thead class="gujju-theme">
					<tr>
						<th>bus no</th>
						<th>Route</th>
						<th>destination</th>
						<th>distance</th>
						<th>arrival time</th>
						<th>departure time</th>
						<th>time taken</th>
						<th>off day</th>
						<th >off date</th>
						<th colspan="3">Action</th>
					</tr>
				</thead>
				<tbody>
					<%
					for (int i = 0; i < scheduleDetailBeanList.size(); i++) {
						ScheduleDetailBean scheduleDetailBean = scheduleDetailBeanList.get(i);
				%>
					<tr>
						<td ><%=scheduleDetailBean.getBusNo()%></td>
						<td  ><%=scheduleDetailBean.getSource()%></td>
						<td><%=scheduleDetailBean.getDestination()%></td>
						<td><%=scheduleDetailBean.getDistance()%></td>
						<td><%=scheduleDetailBean.getArrivalTime()%></td>
						<td><%=scheduleDetailBean.getDepartureTime()%></td>
	
	<%Integer time = scheduleDetailBean.getTimeTaken();
	String TimeTaken="";
	if(time>60)
	{
		time/=60;
		TimeTaken+=time+" Hr";
	}
	else
	{
		TimeTaken+=time+"min";
	}
	%>
						<td><%=TimeTaken %></td>

						<td style="font-size: smaller;"><%=ValidateUtils.getDay(scheduleDetailBean
						.getWeekOfDay())%>
						</td>
						<td style="font-size: 10px;">
							<%
							if (scheduleDetailBean.getOffDate() == null) {
						%> - <%
 	} else {
 %> 
  <%=scheduleDetailBean.getOffDate()%>  <%
							}
						%>
						</td>
						<td><a
							href="ScheduleDetailUpdateServlet?id=<%=scheduleDetailBean.getScheduleId()%>"><img src="Gujjubus-photos/edit.ico" height="30" width="30" /></a>
							</td><td>
							<a
							href="ScheduleDetailDeleteServlet?id=<%=scheduleDetailBean.getScheduleId()%>">										<img src="Gujjubus-photos/Recycle Bin.ico" height="30"
										width="30" /></a>
						</td><td><a
							href="ScheduleSessionServlet?id=<%=scheduleDetailBean.getScheduleId() %>" class=" fa-ticket fa gujju-blue gujju-btn gujju-xxlarg">Book Ticket</a>
						</td>
					</tr>


					<%
					}
				%>
				</tbody>
			</table>
		</div>
	</div></div>
	<script type="text/javascript">
	<!--
		//-->
		$(document).ready(function() {
			$("#treeSchedule").show();
			$("#schedule").addClass("effect");
			$("#listSchedule").addClass("effect");
		});
	</script>

</body>
</html>