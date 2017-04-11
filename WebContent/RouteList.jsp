<%@page import="com.digimation.gujjubus.bean.RouteBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Route List</title>
<noscript>
	<div style="color: #FF0000">place enable java script</div>
</noscript>

<link rel="icon" href="Gujjubus-photos/logo.ico" /></head>
<body>
	<%@include file="HomePage.jsp"%>
		<%

ArrayList<RouteBean> listOfRouteBeans=(ArrayList)request.getAttribute("listofroute");
if(listOfRouteBeans!=null)
%>
<font size="+3" color="red"  class=" alert-warning">
${msgstation}
</font>
<font size="+3" color="red"  class=" alert-info">
		<%="<br>"+listOfRouteBeans.size()+" records found" %>
		</font>
		<form>
			<div class="container">
				<div class="row">
	<div class="col-lg-9">
						<table class="table-hover table gujju-card-16">
							<thead class="gujju-theme">
								<tr>
									<th>Source</th>
									<th>Destination</th>
									<th>Is available</th>
									<th colspan="2">Action</th>
								</tr>
							</thead>
							<tbody>
								<% for(int i=0;i<listOfRouteBeans.size();i++)
	{
	
		RouteBean listOfRouteBean =listOfRouteBeans.get(i);	
		
%>

								<tr>
									<td><%= listOfRouteBean.getSource()%></td>
									<td><%= listOfRouteBean.getDestination()%></td>

									<td><%= listOfRouteBean.getIsAvailable() %></td>

									<td><a
										href="RouteUpdateServlet?id=<%=listOfRouteBean.getRouteId()%>"><img
											src="Gujjubus-photos/edit.ico" height="30" width="30">
									</a> <a
										href="RouteDeleteServlet?id=<%=listOfRouteBean.getRouteId()%>"><img
											src="Gujjubus-photos/Recycle Bin.ico" height="30" width="30">
									</a></td>
								</tr>
								<% } %>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</form>
		<script>
$(document).ready(function(){
	$("#treeRoute").show();
	$("#route").addClass("effect");
	$("#listRoute").addClass("effect");
});
</script>

</body>
</html>