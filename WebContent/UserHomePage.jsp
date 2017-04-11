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

<!DOCTYPE html PUBLIC "-//gujjuC//DTD XHTML 1.0 Transitional//EN" "http://www.gujju.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>GujjuBus.com</title>
<style>
input {
	text-transform: capitalize;
}
</style>

<link rel="icon" href="Gujjubus-photos/logo.ico" />
</head>
<body>
	<%@ include file="UserHeader.jsp"%>
	${msguser} ${msgreservation}
	<%!ArrayList<StationBean> stationBeansList;%>
	<br />
	<br />
	<form action="UserScheduleListServlet" method="post">
		<div class="gujju-container " style="margin-left: 320px;">
			 <div class=" gujju-col m9 gujju-card-8"
			style="margin-left: 30px; text-align: center;"	>
				<div class="row">

					<h3 style="text-align: center;">
						Search Bus Here <i class="fa-search fa" style="color: #0099FF"></i>
					</h3>
					<br />
					<div class="col-lg-13">
						<label class="col-lg-3">From :</label>
						<div class="col-md-7">
							<input list="Source" name="Source" maxlength="20"
								placeholder="Source" class="form-control" autocomplete="off"
								value="${param.Destination}" />
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
							<font color="red"> ${msgsource}</font>
						</div>
					</div>
					<br /> <br />
					<div class="col-lg-13">
						<label class="col-lg-3">To :</label>
						<div class="col-md-7">
							<input list="Destination" placeholder="Destination"
								name="Destination" maxlength="20" class="form-control"
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
 %> </datalist>
							<font color="red"> ${msgdestination}</font>
						</div>

						<br /> <br />
					</div>
					<br />
					<div class="gujju-col m7">
						<button type="submit" class="fa-search fa   gujju-btn gujju-theme"
							style="margin-left: 180px;">&emsp;Search Bus</button>
						<br /> <br />
					</div>
				</div>
			</div>
 

		</div>
	</form>


	<%@include file="UserFooter.jsp"%>
</body>
</html>
