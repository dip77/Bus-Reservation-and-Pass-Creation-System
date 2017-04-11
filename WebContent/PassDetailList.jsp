<%@page import="com.digimation.gujjubus.bean.PassDetailBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PassDetail Detail List</title>
<link rel="icon" href="Gujjubus-photos/logo.ico" /></head>
<body class="col-*-*">
	<%@include file="HomePage.jsp"%>
		<div class="container">
			<div class="row">
				<div class="col-lg-10">
					 <%
					ArrayList<PassDetailBean> listOfPassDetailBeans = (ArrayList) request.getAttribute("listofpassdetail");
					if (listOfPassDetailBeans != null)
				%>

					<%
					PassDetailBean listOfPassDetailBean = listOfPassDetailBeans.get(0);
				%>
					<form>
						<table class="table-hover table gujju-card-4">
							<tbody>
								<tr>
									<td>Photo : <img alt="photo not found"
										src="<%="upload/pass/"+listOfPassDetailBean.getPhoto()%>"
										height="150" width="150"></td>

									<td>First Name : <%=listOfPassDetailBean.getFirstName()%></td>
								<tr>
									<td>Middle Name : <%=listOfPassDetailBean.getMiddleName()%></td>
								<tr>
									<td>Last Name : <%=listOfPassDetailBean.getLastName()%></td>
								<tr>
									<td>Email : <%=listOfPassDetailBean.getEmail()%></td>
								</tr>
								<tr>
									<td>Source : <%=listOfPassDetailBean.getSource()%></td>
								</tr>
								<tr>
									<td>Destination : <%=listOfPassDetailBean.getDestination()%>
									</td>
								</tr>

								<tr>
									<td>Pass Validity : <%=listOfPassDetailBean.getValidity()%></td>
								</tr>
								<tr>
									<td>Term Validity : <%=listOfPassDetailBean.getTermValidity()%>
									</td>
								</tr>
								<tr>
									<td>Amount : <%=listOfPassDetailBean.getTotalAmount()%></td>
								</tr>
								<tr>
									<td>Organization : <%=listOfPassDetailBean.getOrganizationName()%>
									</td>
								</tr>
								<tr>
									<td>Organization Address : <%=listOfPassDetailBean.getOrganizationAddress()%>
									</td>
								</tr>

							</tbody>
						</table>
					</form>
				</div>
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