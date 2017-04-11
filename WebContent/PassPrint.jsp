<%@page import="java.util.Date"%>
<%@page import="com.digimation.gujjubus.bean.PassBean"%>
<%@page import="com.digimation.gujjubus.bean.UserBean"%>
<%@page import="com.digimation.gujjubus.bean.OrganizationBean"%>
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
	
	<div class="col-lg-6">
		<div class="container">
			<div class="row">
				<div class="col-lg-10">
					<div class="btn-success btn">
						<a href="UserHomePage.jsp" style="text-decoration: none">Back</a>
					</div>
					<%		
					PassDetailBean listOfPassDetailBean =  (PassDetailBean)request.getAttribute("PassDetailBean");
					UserBean userBean=(UserBean)session.getAttribute("userBean");
					if (listOfPassDetailBean != null)
				%>
					<form>
						<table class="table-hover table gujju-card-4">
							<tbody>
								<tr>
									<td>Photo : <img alt="photo not found"
										src="<%="upload/pass/"+listOfPassDetailBean.getPhoto()%>"
										height="150" width="150"></td>

									<td>First Name : <%=userBean.getFirstName()%></td>
								<tr>
									<td>Middle Name : <%=userBean.getMiddleName()%></td>
								<tr>
									<td>Last Name : <%=userBean.getLastName()%></td>
								<tr>
									<td>Email : <%=userBean.getEmail()%></td>
								</tr>
								<tr>
									<td>Source : <%= listOfPassDetailBean.getSource()%></td>
								</tr>
								<tr>
									<td>Destination : <%=listOfPassDetailBean.getDestination()%>
									</td>		
								</tr>
									<tr>
									<td>Start Date : <%=new Date().toString().substring(0, 10)+" 2015"%>
									</td>
									
							
								</tr>
							
									<tr>
									<td>Pass Validity : <%=listOfPassDetailBean.getValidity()+" months"%></td>
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
						<input type="button" onclick="p();" value="Print"></a>
							</tbody>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script>
	function p()
	{
		window.print();
	}
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