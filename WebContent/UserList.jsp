<%@page import="com.digimation.gujjubus.bean.UserBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User List</title>
<noscript>
	<div style="color: #FF0000">place enable java script</div>
</noscript>
<link rel="icon" href="Gujjubus-photos/logo.ico" /></head>
<body class="col-*-*">
	<%@include file="HomePage.jsp"%>
	<%
		ArrayList<UserBean> listOfUserBeans = (ArrayList) request
				.getAttribute("listofuser");
		if (listOfUserBeans != null)	
	%>
	<font size="+3" color="red"  class=" alert-warning">
	${msguser}
</font>
<font size="+3" color="red"  class=" alert-info">
	<%="<br>" + listOfUserBeans.size() + " records found"%>
</font>
	<form>
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-9">
					<table class="table-hover table table-responsive gujju-card-16">
						<thead class="gujju-theme">
							<tr>
								<th>First Name</th>
								<th>Middle Name</th>
								<th>Last Name</th>
								<th>Gender</th>
								<th>City</th>
								<th>Email</th>
								<th>Mobile</th>
								<th>Address</th>
								<th>Is active</th>
								<th colspan="2">Action</th>
							</tr>
						</thead>
						<tbody>
							<%
							for (int i = 0; i < listOfUserBeans.size(); i++) {

								UserBean listOfUserBean = listOfUserBeans.get(i);
						%>
							<tr>

								<td><%=listOfUserBean.getFirstName()%></td>
								<td><%=listOfUserBean.getMiddleName()%></td>
								<td><%=listOfUserBean.getLastName()%></td>

								<td><%=listOfUserBean.getGender()%></td>

								<td><%=listOfUserBean.getCity()%></td>

								<td><%=listOfUserBean.getEmail()%></td>
								<td><%=listOfUserBean.getMobile()%></td>

								<td><%=listOfUserBean.getAddress()%></td>

								<td><%=listOfUserBean.getIsActive()%></td>

								<td><a
									href="UserUpdateServlet?id=<%=listOfUserBean.getUserId()%>"><img
										src="Gujjubus-photos/edit.ico" width="30" height="30" /> </a> </td><td>	<a
									href="UserDeleteServlet?id=<%=listOfUserBean.getUserId()%>"><img
										src="Gujjubus-photos/Recycle Bin.ico" width="30" height="30" />
								</a>
								</td>
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
	<script>
$(document).ready(function(){
	$("#treeUser").show();
	$("#User").addClass("effect");
	$("#listUser").addClass("effect");
});
</script>

</body>
</html>