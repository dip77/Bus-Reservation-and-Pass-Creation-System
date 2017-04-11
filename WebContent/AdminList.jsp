<%@page import="com.digimation.gujjubus.bean.AdminBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<meta charset="utf-8" />
 <head>
<title>AdminList</title>

  <link rel="icon" href="Gujjubus-photos/logo.ico" /></head>
<body class="col-*-*">

	<%@include file="HomePage.jsp"%>

	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-9">
		<a href="AdminInsert.jsp" class="gujju-blue gujju-btn" style="margin-bottom: 10px">Add Another</a>
<br/>	
				<%
		ArrayList<AdminBean> listOfAdminBeans = (ArrayList) request.getAttribute("listofadmin");
		if (listOfAdminBeans != null)
	%>
		<font size="+3" color="red"  class=" alert-warning">		${msgadmin}</font>
<br />
			<font size="+3" color="red"  class=" alert-info">	<%=listOfAdminBeans.size() + " records found"%></font>

				<table  id="example" class="display table table-hover gujju-card-16" cellspacing="0" width="100%">
					<thead class="gujju-theme text-uppercase">
						<tr>
							<th>First Name</th>
							<th>Middle Name</th>
							<th>Last Name</th>
							<th>Gender</th>
							<th>City</th>
							<th>Email</th>
							<th>Is active</th>
							<th colspan="2">Action</th>
						</tr>
					</thead>

					<tbody>
						<%
								for (int i = 0; i < listOfAdminBeans.size(); i++) {

									AdminBean listOfAdminBean = listOfAdminBeans.get(i);
							%>

						<tr>


							<td><%=listOfAdminBean.getFirstName()%></td>
							<td><%=listOfAdminBean.getMiddleName()%></td>
							<td><%=listOfAdminBean.getLastName()%></td>

							<td><%=listOfAdminBean.getGender()%></td>

							<td><%=listOfAdminBean.getCity()%></td>

							<td><%=listOfAdminBean.getEmail()%></td>

							<td><%=listOfAdminBean.getIsActive()%></td>

							<td><a
								href="AdminUpdateServlet?id=<%=listOfAdminBean.getAdminId()%>">
									<img src="Gujjubus-photos/edit.ico" height="30" width="30" />
							</a> </td><td><a
								href="AdminDeleteServlet?id=<%=listOfAdminBean.getAdminId()%>">
									<img src="Gujjubus-photos/Recycle Bin.ico" height="30"
									width="30" /> </a></td>
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
		$(document).ready(function() {

			$("#treeRegistration").show();
			$("#AdminList").addClass("effect ");
			$("#registration").addClass("effect");

		});
	</script>
 
  

</body>
</html>
