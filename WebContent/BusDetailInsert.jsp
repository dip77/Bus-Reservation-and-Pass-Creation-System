<%@page import="com.digimation.gujjubus.dao.BusDAO"%>
<%@page import="com.digimation.gujjubus.bean.BusBean"%>
<%@page import="com.digimation.gujjubus.dao.RouteDAO"%>
<%@page import="com.digimation.gujjubus.bean.RouteBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.digimation.gujjubus.bean.BusDetailBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bus Detail Insert</title>





<noscript>
	<div style="color: #FF0000">place enable java script</div>
</noscript>
<link rel="icon" href="Gujjubus-photos/logo.ico" /></head>
<body class="col-*-*">
	<%@include file="HomePage.jsp"%>
			<%!ArrayList<RouteBean> routeBeansList;
	ArrayList<BusBean> busBeansList;
	%>
	<div class="col-lg-8">
			<form action="BusDetailInsertServlet" method="post">
		<div class="container">
				<div class="row">
					<div class="col-lg-9">
						<label class="col-sm-3"> <font size="+1"> Route</font>
						</label>
						<div class="col-lg-5">
							<select name="selsource" id="txtbusdepo" class="form-control">
								<option value="0" selected="selected">select source</option>
								<%
								routeBeansList = new RouteDAO().getRouteList();
								for (int i = 0; i < routeBeansList.size(); i++) {

									String tmp = "unselected";
									String type = request.getParameter("selsource");
									if (type == null)
										tmp = "unselected";
									else if (routeBeansList.get(i).getSourceId() == Integer
											.parseInt(type))
										tmp = "selected";
							%>
								<option value=<%=routeBeansList.get(i).getRouteId()%> <%=tmp%>><%=routeBeansList.get(i).getSource()+" - "+routeBeansList.get(i).getDestination() %></option>
								<%
									}
							%>
							</select><font color="red"><b>${msgsource}</b></font>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-9">
						<label class="col-sm-3"> <font size="+1">Bus No :</font>
						</label>
						<div class="col-lg-5">
							<select name="selbusNo" id="txtbusdepo" class="form-control">
								<option value="0" selected="selected">select bus no</option>

								<%
									busBeansList = new BusDAO().getBusList();
									for (int i = 0; i < busBeansList.size(); i++) {

										String tmp = "unselected";
										String type = request.getParameter("selbusNo");
										if (type == null)
											tmp = "unselected";
										else if (busBeansList.get(i).getBusNo().equals(type))
											tmp = "selected";
								%>

								<option value=<%=busBeansList.get(i).getBusNo()%> <%=tmp%>><%=busBeansList.get(i).getBusNo()%></option>
								<%
									}
								%>
							</select><font color="red"><b>${msgbusno}</b></font>
						</div>
					</div>
				</div>
				<br />
				<div class="col-lg-5">
					<input type="submit" class="gujju-btn gujju-theme " />
				</div>
				<div class="col-md-4">
					<input type="reset" class="gujju-btn gujju-green "
						value="Clear" />
				</div>
		</div>
			</form></div>
	<script>
		$(document).ready(function() {
			$("#treeBus").show();
			$("#treeBusdetail").show();
			$("#bus").addClass("effect");
			$("#Busdetail").addClass("effect");
			$("#addBusdetail").addClass("effect");
		});
	</script>
</body>
</html>