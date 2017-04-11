<%@page import="com.digimation.gujjubus.dao.BusDAO"%>
<%@page import="com.digimation.gujjubus.bean.RouteBean"%>
<%@page import="com.digimation.gujjubus.dao.StationDAO"%>
<%@page import="com.digimation.gujjubus.bean.StationBean"%>
<%@page import="com.digimation.gujjubus.bean.BusBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Route Update</title>






<noscript>
	<div style="color: #FF0000">place enable java script</div>
</noscript>

<link rel="icon" href="Gujjubus-photos/logo.ico" /></head>
<body class="col-*-*">
	<%@include file="HomePage.jsp"%>
	<div class="col-lg-6">
		<%!ArrayList<StationBean> stationBeansList;%>
		<form action="RouteValidateServlet?id=${param.id}" method="post">
			<div class="container">
				<div class="row">
					<div class="col-lg-10">
						<label class="col-sm-3"> <font  
							size="+1"> Source</font> </label>
						<div class="col-lg-6">
							<select name="selsource" id="txtbusdepo" class="form-control"
								autofocus >
							<%
							stationBeansList = new StationDAO().getStationList();
							RouteBean routeBean = (RouteBean) request.getAttribute("routeBean");
							int type = routeBean.getSourceId();
							for (int i = 0; i < stationBeansList.size(); i++) {
								String tmp = "unselected";
								if (stationBeansList.get(i).getStationId() == type)
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
					<br /> <br />
				</div>
				<div class="row">
					<div class="col-lg-10">
						<label class="col-sm-3"> <font  
							size="+1"> Destination</font> </label>
						<div class="col-lg-6">


							<select name="seldestination" id="txtbusdepo"
								class="form-control">


								<%
									stationBeansList = new StationDAO().getStationList();
									type = routeBean.getDestinationId();
									for (int i = 0; i < stationBeansList.size(); i++) {

										String tmp = "unselected";
										if (stationBeansList.get(i).getStationId() == type)
											tmp = "selected";
								%>

								<option value=<%=stationBeansList.get(i).getStationId()%>
									<%=tmp%>><%=stationBeansList.get(i).getStationName()%></option>
								<%
									}
								%>
							</select>
							<font color="red"><b>${msgdes}</b></font>
						</div>
						<br /> <br />
					</div>
				</div>
				<%
							String y = "", n = "";
							if (routeBean.getIsAvailable().equals("y"))
								y = "checked";
							else
								n = "checked";
						%>
				<div class="row">
					<div class="col-lg-10">
						<label class="col-sm-4"> <font  
							size="+1"> Is Available </font> </label>
						<div class="col-lg-6">

							<input type="radio" name="rdoavailable" value="y" <%=y%>>yes
							<input type="radio" name="rdoavailable" value="n" <%=n%>>no
							<br /> <br />
						</div>
					</div>
					<div class="col-lg-5">
						<input type="submit" class="gujju-btn gujju-theme " />
					</div>
					<div class="col-md-4">
						<input type="reset" class="gujju-btn gujju-green " value="Clear" />
					</div>
				</div>
			</div>
		</form>
	</div>
	<script>
$(document).ready(function(){
	$("#treeRoute").show();
	$("#route").addClass("effect");
	$("#addRoute").addClass("effect");
});
</script>

</body>
</html>