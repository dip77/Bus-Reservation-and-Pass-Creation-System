<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.digimation.gujjubus.dao.BusDAO"%>
<%@page import="com.digimation.gujjubus.bean.BusDetailBean"%>
<%@page import="com.digimation.gujjubus.bean.BusBean"%>
<%@page import="com.digimation.gujjubus.util.ValidateUtils"%>
<%@page import="com.digimation.gujjubus.bean.ScheduleDetailBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.digimation.gujjubus.dao.StationDAO"%>
<%@page import="com.digimation.gujjubus.bean.StationBean"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Schedule Insert</title>





<link rel="icon" href="Gujjubus-photos/logo.ico" /></head>
<body class="col-*-*">
	<%@include file="HomePage.jsp"%>
	<div class="col-lg-6">
		<br />

		<%!ArrayList<StationBean> stationBeansList;%>

		<br />
		<div class="container">
			<%
				ScheduleDetailBean scheduleDetailBean = (ScheduleDetailBean) request
						.getAttribute("scheduleDetailBean");
			%>

			<form
				action="ScheduleDetailValidateServlet?id=<%=scheduleDetailBean.getScheduleId()%>"
				method="post">
				<%
					ArrayList<BusBean> busDAOs = new BusDAO().getBusList();
				%>
				<label class="col-sm-2"> Bus No</label>
				<div class="row">
					<div class="col-lg-5">
						<input list="Source" name="selbusno" id="selbusno"
							class="col-lg-2 form-control" autocomplete="off"
							value="<%=scheduleDetailBean.getBusNo()%>" />
						<datalist id="Source"> <%
 	for (int i = 0; i < busDAOs.size(); i++) {
 		String tmp = "unselected";
 %>
						<option value="<%=busDAOs.get(i).getBusNo()%>"></option>
						<%
							}
						%> </datalist>
						<br /> 
						<font color="red"><b>${msgbusno}</b></font> <br />
					</div>
				</div>

				<label class="col-sm-2"> Source </label>
				<div class="row">
					<div class="col-md-5">
						<input list="Source" name="Source" class="form-control"
							value="<%=scheduleDetailBean.getSource()%>" autocomplete="off" />
						<datalist id="Source"> <%
 	stationBeansList = new StationDAO().getStationList();
 	int type = scheduleDetailBean.getSourceId();

 	for (int i = 0; i < stationBeansList.size(); i++) {
 %>
						<option value="<%=stationBeansList.get(i).getStationName()%>"><%=stationBeansList.get(i).getStationName()%></option>
						<!-- all option value  name like Ahmedabad--> <%
 	}
 %> </datalist>
					</div>
				<font color="red"><b>	${msgsource}</b></font>
				</div>

				<br /> <label class="col-sm-2"> Destination </label>
				<div class="row">
					<div class="col-md-5">
						<input list="Destination" name="Destination" class="form-control"
							value="<%=scheduleDetailBean.getDestination()%>"
							autocomplete="off" />
						<datalist id="Destination"> <%
								stationBeansList = new StationDAO().getStationList();
								type = scheduleDetailBean.getDestinationId();
								for (int i = 0; i < stationBeansList.size(); i++) {

									String tmp = "unselected";
									if (stationBeansList.get(i).getStationId() == type)
										tmp = "selected";
							%>


						<option value="<%=stationBeansList.get(i).getStationName()%>"
							<%=tmp%>></option>
						<!-- all option value  name like Gandhinagar--> <%
 	}
 %> </datalist>
					</div>
					<font color="red"><b>${msgdest}</b></font>
				</div>

				<br /> <label class="col-sm-2"> Week Of </label>
				<div class="row">
					<div class="col-md-5">
						<%
							String arry[] = new String[8];
							for (int i = 0; i < arry.length; i++) {
								if (scheduleDetailBean.getWeekOfDay() == i)
									arry[i] = "selected";
								else
									arry[i] = "selected";
							}
						%>
						<select class="form-control" name="weekOffDay">
							<option value="0" <%=arry[0]%>>None</option>
							<option value="1" <%=arry[1]%>>SUNDAY</option>
							<option value="2" <%=arry[2]%>>MONDAY</option>
							<option value="3" <%=arry[3]%>>TUESDAY</option>
							<option value="4" <%=arry[4]%>>WEDNESDAY</option>
							<option value="5" <%=arry[5]%>>THURSDAY</option>
							<option value="6" <%=arry[6]%>>FRIDAY</option>
							<option value="7" <%=arry[7]%>>SATURDAY</option>
						</select>
					</div>

				</div>
				<br /> <label class="col-sm-2"> Off Date </label>
				<div class="row">
					<div class="col-md-5">
						<input type="date" name="weekOffDate"
							value="<%=scheduleDetailBean.getOffDate()%>" class="form-control" />
					</div>

				</div>
				<br /> <label class="col-sm-2"> Arrival Time </label>
				<div class="row">
					<div class="col-md-5">
						<input type="time" name="arrivalTime"
							value="<%=scheduleDetailBean.getArrivalTime()%>"
							class="form-control" />
					</div>
					<font color="red"><b>${msgarrv}</b></font>
				</div>

				<br /> <label class="col-sm-2"> Departure Time </label>
				<div class="row">
					<div class="col-md-5">
						<input type="time" name="departureTime"
							value="<%=scheduleDetailBean.getDepartureTime()%>"
							class="form-control" />
					</div>
					<font color="red"><b>${msgdep}</b></font>
				</div>
				<br /> <label class="col-sm-2"> Reach Time </label>
				<div class="row">
					<div class="col-md-5">
						<input type="time" name="reachTime" class="form-control"
							value="<%=scheduleDetailBean.getReachTime()%>" />
					</div>
					<font color="red"><b>${msgreach}</b></font>
				</div>
				<br /> <div class="col-lg-5">
					<input type="submit" class="gujju-btn gujju-theme " onclick="Validation();" />
				</div>
				<div class="col-md-4">
					<input type="reset" class="gujju-btn gujju-green " value="Clear" />
				</div>
			</form>

		</div>
	</div>
	<script type="text/javascript">
	<!--
		//-->
		$(document).ready(function() {
			$("#treeSchedule").show();
			$("#schedule").addClass("effect");
			$("#addSchedule").addClass("effect");
		});
	</script>

</body>
</html>
