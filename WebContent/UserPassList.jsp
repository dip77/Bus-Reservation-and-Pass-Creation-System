<%@page import="com.digimation.gujjubus.bean.PassDetailBean"%>
<%@page import="com.digimation.gujjubus.bean.PassBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pass List</title> 
<link rel="icon" href="Gujjubus-photos/logo.ico" /></head>
<body class="col-*-*">
<%@include file="UserHomePage.jsp" %>
<div class="col-lg-6">
	<div class="container">
		<div class="row">

			<%
				ArrayList<PassDetailBean> listOfPassBeans = (ArrayList) session
						.getAttribute("passDetailBean");
				if (listOfPassBeans != null)
			%>
			<font size="+3" color="red"  class=" alert-warning">
			${msgpass}
</font>
<font size="+3" color="red"  class=" alert-info">
			<%="<br>" + listOfPassBeans.size() + " records found"%>
</font>

			<form>
				<div class="col-lg-10">

					<table class="table-hover table gujju-card-4">
						<thead class="panel-heading panel-info">
							<tr>
								<th>Start Date</th>
								<th>End Date</th>
								<th>Source</th>
								<th>Destination</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody class="panel-body">
							<%
								for (int i = 0; i < listOfPassBeans.size(); i++) {

									PassDetailBean listOfPassBean = listOfPassBeans.get(i);	
							%>
							<tr>
								<td><%=listOfPassBean.getStartDate()%></td>
								<td><%=listOfPassBean.getEndDate()%></td>
								<td><%=listOfPassBean.getSource()%></td>
								<td><%=listOfPassBean.getDestination()%></td>


								<td><a
									href="UserPassPrintServlet?id=<%=listOfPassBean.getPassId()%>"><img
										src="Gujjubus-photos/edit.ico" height="30" width="30" /> </a></td>
										</tr>
							<%
								}
							%>
						</tbody>
				
					</table>
		</div>
			</form></div></div>
</div>
<script>
$(document).ready(function(){
	$("#treePass").show();
	$("#treePass").show();
	$("#treePassinner").show();
	$("#Passinner").addClass("effect");
	$("#pass").addClass("effect");
	$("#listPass").addClass("effect");
});
</script></body>
</html>