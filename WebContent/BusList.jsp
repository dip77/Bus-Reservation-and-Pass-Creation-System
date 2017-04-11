<%@page import="com.digimation.gujjubus.bean.BusBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bus List</title>



 <noscript>
	<div style="color: #FF0000">place enable java script</div>
</noscript>

<link rel="icon" href="Gujjubus-photos/logo.ico" /></head>
<body class="col-*-*">
<%@include file="HomePage.jsp" %>
	<div class="col-lg-9">
			<font size="+3" color="red"  class=" alert-warning">${msgbus}</font>
	<%
		ArrayList<BusBean> listOfBusBeans = (ArrayList) request.getAttribute("listofbus");
		if (listOfBusBeans != null)
	%>
	
<font size="+3" color="red"  class=" alert-warning">	${msgbuscat}</font>
<font size="+3" color="red"  class=" alert-info">
	<%="<br>" + listOfBusBeans.size() + " records found"%>
	</font>
	<form>
		<div class="container-fluid">
			<div class="row">
			<div class="col-lg-15">
					<table class="table-hover table gujju-card-4">
						<thead class="gujju-theme">
							<tr>
								<th>Bus No</th>
								<th>Bus Category</th>
								<th>Bus Type</th>
								<th>Bus Capacity</th>
								<th>Bus Depo</th>
								<th>Bus Availability</th>
								<th colspan="2">Action</th>
							</tr>
						</thead>
						<tbody>
							<%
								for (int i = 0; i < listOfBusBeans.size(); i++) {

									BusBean listOfBusBean = listOfBusBeans.get(i);
							%>
							<tr>
								<td><%=listOfBusBean.getBusNo()%></td>
								<td><%=listOfBusBean.getBusCategory()%></td>
								<td><%=listOfBusBean.getBusType()%></td>
								<td><%=listOfBusBean.getCapacity()%></td>
								<td><%=listOfBusBean.getBusDepo()%></td>
								<td><%=listOfBusBean.getIsAvailable()%></td>

								<td><a
									href="BusUpdateServlet?id=<%=listOfBusBean.getBusNo()%>"><img
										src="Gujjubus-photos/edit.ico" height="30" width="30" />
								</a> <a href="BusDeleteServlet?id=<%=listOfBusBean.getBusNo()%>"><img
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
	</form>
	
</div>
	<script>
		$(document).ready(function() {
			$("#treeBus").show();
			
			$("#treeBusinner").show();
			$("#Businner").addClass("effect");
			$("#bus").addClass("effect");
			$("#listBus").addClass("effect");
		});
	</script>

</body>
</html>