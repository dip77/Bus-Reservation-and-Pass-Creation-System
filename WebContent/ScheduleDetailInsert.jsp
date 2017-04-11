<%@page import="com.sun.org.apache.regexp.internal.recompile"%>
<%@page import="com.digimation.gujjubus.dao.RouteDAO"%>
<%@page import="com.digimation.gujjubus.bean.RouteBean"%>
<%@page import="com.digimation.gujjubus.dao.BusDetailDAO"%>
<%@page import="com.digimation.gujjubus.bean.BusDetailBean"%>
<%@page import="com.digimation.gujjubus.dao.BusDAO"%>
<%@page import="com.digimation.gujjubus.bean.BusBean"%>
<%@page import="com.digimation.gujjubus.dao.StationDAO"%>
<%@page import="com.digimation.gujjubus.bean.StationBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Schedule Insert</title>
<script type='text/javascript'
	src='/BUSINDICATOR/dwr/interface/RouteDAO.js'></script>
<script type='text/javascript' src='/BUSINDICATOR/dwr/engine.js'></script>
<script type='text/javascript' src='/BUSINDICATOR/dwr/util.js'></script>
<script type="text/javascript">
	function getBusNo(busid) {
		dwr.util.removeAllOptions("selbusno");
		if (busid == '') {
			var data = [ {
				BusNumber : '--select Bus No --',
				Busid : +''
			} ];
			dwr.util.addOptions("selbusno", data, "busNo", "busNo");
		} else {
			RouteDAO.getDistinctBusNo(busid, function(data) {
				dwr.util.addOptions("selbusno", data, "busNo", "busNo");
			});
		}
	}
</script>
<link rel="icon" href="Gujjubus-photos/logo.ico" /></head>
<body class="col-*-*">
	<%@include file="HomePage.jsp"%>
	<div class="col-lg-6">
		<br />
		<div class="container">
			<form action="ScheduleDetailInsertServlet" method="post">
				<%!ArrayList<StationBean> stationBeansList;%>

				<%
				
				ArrayList<BusDetailBean> busDetailBeans=new BusDetailDAO().getDistinctBusDetailList();
				%>
				<label class="col-sm-2"> Route</label>
				<div class="row">
					<div class="col-lg-5">
						<select name="selroute" class="col-lg-2 form-control"
							onChange="java:getBusNo(this.value)">
							<option value="0">select route</option>
							<%
						for(int i=0;i<busDetailBeans.size();i++){
							RouteBean routeBean=new RouteDAO().getRouteByPK2(busDetailBeans.get(i).getRouteid());	
							if(routeBean.getRouteId()==busDetailBeans.get(i).getRouteid()){
					%>
							<option value="<%=routeBean.getRouteId()%>"><%= routeBean.getSource()+"  -  "+routeBean.getDestination() %>
							</option>
							<%
						}}
					%>
						</select><br /> <font color="red"><b> ${msgroute}</b> </font> <br />
					</div>
				</div>
				<label class="col-sm-2"> Bus No</label>
				<div class="row">
					<div class="col-lg-5">
						<select name="selbusno" id="selbusno"
							class="col-lg-2 form-control">
							<option value="0">select bus no</option>

						</select> 
						<font color="red"><b> ${msgbusno}</b> </font>
						<br />  <br />
					</div>
				</div>

				<label class="col-sm-2"> Source </label>
				<div class="row">
					<div class="col-md-5">
						<input list="Source" name="Source" class="form-control"
							autocomplete="off" value="${param.Destination}" />
						<datalist id="Source"> <%
 	stationBeansList = new StationDAO().getStationList();

 	for (int i = 0; i < stationBeansList.size(); i++) {

 		String tmp = "unselected";
 		String type = request.getParameter("seldestination");
 		if (type == null)
 			tmp = "unselected";
 		else if (stationBeansList.get(i).getStationId() == Integer
 				.parseInt(type))
 			tmp = "selected";
 %>


						<option value="<%=stationBeansList.get(i).getStationName()%>"></option>
						<!-- all option value  name like Gandhinagar--> <%
 	}
 %> </datalist>
<font color="red">${msgsource}</font>
					</div>
				</div>
				<br /> <label class="col-sm-2"> Destination </label>
				<div class="row">
					<div class="col-md-5">
						<input list="Destination" name="Destination" class="form-control"
							autocomplete="off" value="${param.Destination}" />
						<datalist id="Destination"> <%
 	stationBeansList = new StationDAO().getStationList();

 	for (int i = 0; i < stationBeansList.size(); i++) {

 		String tmp = "unselected";
 		String type = request.getParameter("seldestination");
 		if (type == null)
 			tmp = "unselected";
 		else if (stationBeansList.get(i).getStationId() == Integer
 				.parseInt(type))
 			tmp = "selected";
 %>


						<option value="<%=stationBeansList.get(i).getStationName()%>"></option>
						<!-- all option value  name like Gandhinagar--> <%
 	}
 %> </datalist> <font color="red">${msgdest}</font>
 	</div>
				</div>
<br />
 <label class="col-sm-2">Distance</label>
				<div class="row">

					<div class="col-md-5">
 <input type="text" value="${param.distance}"  class="form-control" name="distance" maxlength="5"/>

<font color="red"> ${msgdistance}</font>
					</div>
				</div>
 
 
 
				
				<br /> <label class="col-sm-2"> Week Of Day</label>
				<div class="row">

					<div class="col-md-5">
						<select class="form-control" name="weekOffDay">
							<option value="0">Select</option>
							<option value="1">SUNDAY</option>
							<option value="2">MONDAY</option>
							<option value="3">TUESDAY</option>
							<option value="4">WEDNESDAY</option>
							<option value="5">THURSDAY</option>
							<option value="6">FRIDAY</option>
							<option value="7">SATURDAY</option>
						</select>
						${msgoffday}
					</div>
				</div>
				<br /> <label class="col-sm-2"> Week Of Date </label>
				<div class="row">
					<div class="col-md-5">
						<input type="date" name="weekOffDate" class="form-control"
							value="${param.weekOffDate}" />
							
					</div>
				</div>
				<br /> <label class="col-sm-2"> Departure Time </label>
				<div class="row">
					<div class="col-md-5">
						<input type="time" name="departureTime" class="form-control" />
					</div>
					${msgdep}
				</div>

				<br /> <label class="col-sm-2"> Arrival Time </label>
				<div class="row">
					<div class="col-md-5">
						<input type="time" name="arrivalTime" class="form-control" />
					</div>
					${msgarrv}
				</div>
				<br /> <label class="col-sm-2"> Reach Time </label>
				<div class="row">
					<div class="col-md-5">
						<input type="time" name="reachTime" class="form-control" />
					</div>
					${msgarrv}
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
	<script>
		$(document).ready(function() {
			$("#treeSchedule").show();
			$("#schedule").addClass("effect");
			$("#addSchedule").addClass("effect");
		});
	</script>

</body>
</html>
