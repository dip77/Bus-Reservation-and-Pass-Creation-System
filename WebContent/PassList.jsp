<%@page import="com.digimation.gujjubus.bean.PassBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pass List</title>
<noscript>
	<div style="color: #FF0000">place enable java script</div>
</noscript>

<link rel="icon" href="Gujjubus-photos/logo.ico" />
</head>
<body class="col-*-*">
	<%@include file="HomePage.jsp"%>
	<div class="container">
		<div class="row">

			<%
				ArrayList<PassBean> listOfPassBeans = (ArrayList) request
						.getAttribute("listofpass");
				if (listOfPassBeans != null)
			%>
			<font size="+3" color="red"  class=" alert-warning">
			${msgpass}
</font>
<font size="+3" color="red"  class=" alert-info">
			<%="<br>" + listOfPassBeans.size() + " records found"%>
</font>

			<form>
				<div class="col-lg-9">

					<table class="table-hover table gujju-card-4">
						<thead class="gujju-theme ">
							<tr>
								<th>First Name</th>
								<th>Middle Name</th>
								<th>Last Name</th>
								<th>Email</th>
								<th>Pass Type</th>
								<th>Source</th>
								<th>Destination</th>
								<th>Is Active</th>
								<th colspan="3">Action</th>
							</tr>
						</thead>
						<tbody>
							<%
								for (int i = 0; i < listOfPassBeans.size(); i++) {

									PassBean listOfPassBean = listOfPassBeans.get(i);
							%>
							<tr>
								<td><%=listOfPassBean.getFirstName()%></td>
								<td><%=listOfPassBean.getMiddleName()%></td>
								<td><%=listOfPassBean.getLastName()%></td>
								<td><%=listOfPassBean.getEmail()%></td>

								<td><%=listOfPassBean.getPassType()%></td>
								<td><%=listOfPassBean.getSource()%></td>
								<td><%=listOfPassBean.getDestination()%></td>

								<td><%=listOfPassBean.getIsActive()%></td>

								<td><a
									href="PassUpdateServlet?id=<%=listOfPassBean.getPassId()%>"><img
										src="Gujjubus-photos/edit.ico" height="30" width="30" /> </a>
								</td>
								<td><a
									href="PassDeleteServlet?id=<%=listOfPassBean.getPassId()%>"><img
										src="Gujjubus-photos/Recycle Bin.ico" height="30" width="30" />
								</a></td>
								<td><a
									href="PassDetailListServlet?id=<%=listOfPassBean.getPassId()%>"><div
											class="fa-info fa "
											style="font-size: 40px; color: #2196F3; margin-top: -3px;"></div>
								</a>
								</td>
							</tr>
							<%
								}
							%>
						</tbody>

					</table>
				</div>
			</form>
		</div>
	</div>

	<script>
		$(document).ready(function() {
			$("#treePass").show();
			$("#treePass").show();
			$("#treePassinner").show();
			$("#Passinner").addClass("effect");
			$("#pass").addClass("effect");
			$("#listPass").addClass("effect");
		});
	</script>
</body>
</html>