<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin </title>
<link rel="icon" href="Gujjubus-photos/logo.ico" /></head>
<body>
<%@ include file="HomePage.jsp" %>
<div class="gujju-half">
<form action="AdminScheduleListServlet" method="post">
<div class="gujju-container ">
			<div class="gujju-row ">
					<div class="col-lg-10 ">
						<label class="col-md-4" style="font-size: 18px">From :</label>
						<div class="col-lg-8">
							<%!ArrayList<StationBean> stationBeansList;%>
							<input list="Source" name="Source" placeholder="Source" class="form-control"
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
				<font color="red">			${msgsource}</font>
						</div>
					</div>
				</div>
				<br /> <br />
				<div class="gujju-row ">
					<div class="col-lg-10">
						<label class="col-md-4" style="font-size: 18px">To :</label>
						<div class="col-lg-8">
							<input list="Destination" name="Destination" class="form-control"
							placeholder="Destination"	autocomplete="off" value="${param.Destination}" />
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
 %> </datalist>
				<font color="red">			${msgdestination}</font>
						</div>
					</div>
				</div>
				<br /> <br />
				<div class="gujju-row ">
					<div class="col-lg-9 ">
						<input type="submit"
							class="fa-search fa   gujju-btn gujju-blue"
							value="Search Bus" /> <br /> <br />
					</div>
				</div>
			</div>
</form>
</div>
	<script>
		$(document).ready(function() {
			$("#reservation").show();
			$("#treeReservation").show();
			$("#reservation").addClass("effect");
			$("#addReservation").addClass("effect");
		});
	</script>

</body>
</html>