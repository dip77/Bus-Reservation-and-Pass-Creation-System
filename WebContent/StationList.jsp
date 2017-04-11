<%@page import="com.digimation.gujjubus.bean.StationBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Station List</title>




<noscript>
	<div style="color: #FF0000">place enable java script</div>
</noscript>
<link rel="icon" href="Gujjubus-photos/logo.ico" /></head>
<body class="col*-*">
<%@include file="HomePage.jsp" %>
		<div class="container">
		<div class="row">
			<div class="col-lg-9">
				<%
					ArrayList<StationBean> listOfStationBeans = (ArrayList) request
							.getAttribute("listofstation");
					if (listOfStationBeans != null)
				%>
				<font size="+3" color="red"  class=" alert-warning">
				${msgstation}
</font>
		<font size="+3" color="red"  class=" alert-info">
				<%="<br>" + listOfStationBeans.size() + " records found"%>
</font>

				<form>
					<table class="table-hover table gujju-card-4">
						<thead class="gujju-theme">
							<tr>
								<th>Station Name</th>
								<th>City Name</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<%
								for (int i = 0; i < listOfStationBeans.size(); i++) {

									StationBean listOfStationBean = listOfStationBeans.get(i);
							%>
							<tr>
								<td><%=listOfStationBean.getStationName()%></td>
								<td><%=listOfStationBean.getCityName()%></td>

								<td><a
									href="StationUpdateServlet?id=<%=listOfStationBean.getStationId()%>"><img
										src="Gujjubus-photos/edit.ico" width="30" height="30" /> </a> <a
									href="StationDeleteServlet?id=<%=listOfStationBean.getStationId()%>"><img
										src="Gujjubus-photos/Recycle Bin.ico" width="30" height="30" />
								</a></td>
							</tr>
							<%
								}
							%>
						</tbody>
					</table>

				</form>
			</div>
		</div>
	</div>
	<script>
$(document).ready(function(){
	$("#treeStation").show();
	$("#station").addClass("effect");
	$("#listStation").addClass("effect");
});
</script>
	
</body>
</html>