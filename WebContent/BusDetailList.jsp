<%@page import="com.digimation.gujjubus.bean.BusDetailBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.digimation.gujjubus.dao.BusDetailDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bus Detail List</title>
 


 <link rel="icon" href="Gujjubus-photos/logo.ico" /></head>
<body class="col-*-*">
<%	ArrayList<BusDetailBean> busDetailBeansList = (ArrayList) request
.getAttribute("listofbusdetail");
 %>
<%@include file="HomePage.jsp" %>
	<font size="+3" color="red"  class=" alert-warning">	${msgbusdetail}</font>

<font size="+3" color="red"  class=" alert-info">
	<%="<br>" + busDetailBeansList.size() + " records found"%>
	</font>

		<div class="container">
			<div class="row">
	<div class="col-lg-9">

				<table class="table-hover table gujju-card-4">
						<thead class="gujju-theme">
							<tr>
						 		<th>Route</th>
								<th>Bus No</th>
								<th>Is Available</th>
								<th colspan="2">Action</th>
							</tr>
						</thead>
						<tbody>
							<%
								 for (int i = 0; i < busDetailBeansList.size(); i++) {
									BusDetailBean busDetailBean = busDetailBeansList.get(i);
							%>
							<tr>
						 		<td><%=busDetailBean.getSource() + " to "
						+ busDetailBean.getDestination()%>
								</td>
								<td><%=busDetailBean.getBusNo()%></td>
								<td><%=busDetailBean.getIsAvailable()%></td>
								<td><a
									href="BusDetailUpdateServlet?id=<%=busDetailBean.getBusDetailid()%>"><img
										src="Gujjubus-photos/edit.ico" height="30" width="30" />
								</a> <a
									href="BusDetailDeleteServlet?id=<%=busDetailBean.getBusDetailid()%>"><img
										src="Gujjubus-photos/Recycle Bin.ico" height="30" width="30" />
								</a></td>
							</tr>
							<%
								}
							%>
						</tbody>
				</table>
			</div>
		</div>
	</div>
	<script>
$(document).ready(function(){
	$("#treeBus").show();
	$("#treeBusdetail").show();
	$("#bus").addClass("effect");
	$("#Busdetail").addClass("effect");
	$("#listBusdetail").addClass("effect");
});
</script>	
</body>
</html>