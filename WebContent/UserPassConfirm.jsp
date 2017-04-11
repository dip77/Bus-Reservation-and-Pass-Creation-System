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
<%@include file="UserHeader.jsp"%>
		<div class="container">
			<div class="row">
				<div class="col-lg-10">
					<%
					
					PassBean listOfPassDetailBean =  (PassBean)session.getAttribute("PassBean");
					OrganizationBean orgBean=(OrganizationBean)session.getAttribute("orgBean");
					UserBean userBean=(UserBean)session.getAttribute("userBean");
					PassDetailBean passDetailBean=(PassDetailBean)session.getAttribute("passDetailBean");
					if (listOfPassDetailBean != null)
				%>
					<form>
						<a href="UserPassConfirmServlet" class="gujju-green gujju-btn"><i  style="font-size: 30px;"></i>Confirm</a>
						<table class="table-hover table gujju-card-4">
							<tbody>
								<tr>
									<td>Photo : <img alt="photo not found"
										src="<%="upload/pass/"+listOfPassDetailBean.getPhoto()%>"
										height="150" width="150"></td>
</tr>
									<tr>
									<td>First Name : <%=userBean.getFirstName()%></td>
									</tr>
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
									<td>Pass Validity : <%=passDetailBean.getValidity()+" months"%></td>
								</tr>
								<tr>
									<td>Term Validity : <%=listOfPassDetailBean.getTermValidity()+" months"%>
									</td>
								</tr>
								<tr>
									<td>Amount : <%=passDetailBean.getTotalAmount()%></td>
								</tr>
								<tr>
									<td>Organization : <%=orgBean.getOrganizationName()%>
									</td>
								</tr>
								<tr>
									<td>Organization Address : <%=orgBean.getOrganizationAddress()%>
									</td>
								</tr>
							</tbody>
						</table>
					</form>
				</div>
			</div>
		</div>

<%@ include file="UserFooter.jsp" %> 

<script >
$(document).ready(function() {
$("#addorg").show(300);
			$("#showorg").hide();
			
			$("#addorg").click(function(){
				$("#orglist").hide(300);
				$("#showorg").toggle(300);
			
			});
			});
			</script>
</body>
</html>