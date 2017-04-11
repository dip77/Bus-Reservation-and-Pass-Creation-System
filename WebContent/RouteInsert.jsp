<%@page import="com.digimation.gujjubus.dao.StationDAO"%>
<%@page import="com.digimation.gujjubus.bean.StationBean"%>
<%@page import="com.digimation.gujjubus.bean.BusBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.digimation.gujjubus.dao.BusDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Route Insert</title>
 <noscript>
	<div style="color: #FF0000">place enable java script</div>
</noscript>
<link rel="icon" href="Gujjubus-photos/logo.ico" /></head>
<body class="col-*-*">

<%@include file="HomePage.jsp" %>
<div class="col-lg-6">
	<br />
	<%!ArrayList<StationBean> stationBeansList;%>
	<div class="container">
${msgroute}
		<form action="RouteInsertServlet" method="post">
			<div class="row">
				<label class="col-sm-2"><font size="+1"
					 > Source : </font>
				</label>

				<div class="col-md-6">
					<select name="selsource" id="txtbusdepo" class="form-control">
						<option value="0" selected="selected">select source</option>

						<%
							stationBeansList = new StationDAO().getStationList();

							for (int i = 0; i < stationBeansList.size(); i++) {

								String tmp = "unselected";
								String type = request.getParameter("selsource");
								if (type == null)
									tmp = "unselected";
								else if (stationBeansList.get(i).getStationId() == Integer
										.parseInt(type))
									tmp = "selected";
						%>


						<option value=<%=stationBeansList.get(i).getStationId()%>
							<%=tmp%>><%=stationBeansList.get(i).getStationName()%></option>
						<%
							}
						%>
					</select>
					<font color="red"><b>${msgsource}</b></font>
				</div>
			</div>
			<br />
			<div class="row">
				<label class="col-sm-2"><font size="+1" size="+1"
					 > Destination </font> </label>
				<div class="col-lg-6">
					<select name="seldestination" id="txtbusdepo" class="form-control">
						<option value="0" selected="selected">select destination</option>

						<%
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

						<option value=<%=stationBeansList.get(i).getStationId()%>
							<%=tmp%>><%=stationBeansList.get(i).getStationName()%></option>
						<%
							}
						%>
					</select>
					<font color="red"><b>${msgdes}</b></font><br />
					<br /> <br />
					<br />
					</div></div>
					<div class="row">
						<div class="col-lg-10">
							<input type="submit" value="Submit" class="btn-primary btn">
							<input type="reset" class="btn-success btn">
						</div>
					</div>
		</form>
	</div></div>
	<script>
$(document).ready(function(){
	$("#treeRoute").show();
	$("#route").addClass("effect");
	$("#addRoute").addClass("effect");
});
</script>

</body>
</html>