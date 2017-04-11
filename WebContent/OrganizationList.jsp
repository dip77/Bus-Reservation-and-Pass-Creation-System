<%@page import="com.digimation.gujjubus.bean.OrganizationBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Organization List</title>





<link rel="icon" href="Gujjubus-photos/logo.ico" /></head>
<body class="col-*-*">
<%@include file="HomePage.jsp" %>
	<div class="container">
		<div class="row">
			<div class="col-lg-9">

<%
ArrayList<OrganizationBean> listOfOrganizationBeans=(ArrayList)request.getAttribute("listoforg");
if(listOfOrganizationBeans!=null)
%>
<font size="+3" color="red"  class=" alert-warning">
${msgorg}
</font>
<font size="+3" color="red"  class=" alert-info">
<%="<br>"+listOfOrganizationBeans.size()+" records found" %>
</font>
<form>
<table class="table-hover table gujju-card-16">
<thead class="gujju-theme">
<tr>
<th>Organization name</th>
<th>Organization address</th>
<th colspan="2">Action</th>
</tr>
</thead>
<tbody>
<% for(int i=0;i<listOfOrganizationBeans.size();i++)
	{
		OrganizationBean listOfOrganizationBean =listOfOrganizationBeans.get(i);	
%>
<tr>
<td>
<%= listOfOrganizationBean.getOrganizationName() %>
</td>
<td>
<%= listOfOrganizationBean.getOrganizationAddress()%>
</td>
<td>
<a href="OrganizationUpdateServlet?id=<%=listOfOrganizationBean.getOrganizationId()%>"><img src="Gujjubus-photos/edit.ico" height="30" width="30" />
</a>
<a href="OrganizationDeleteServlet?id=<%=listOfOrganizationBean.getOrganizationId()%>"><img src="Gujjubus-photos/Recycle Bin.ico" height="30" width="30" />
</a>
</td>
</tr>
<% } %>
</tbody>
</table>

</form>
</div></div></div>
<script>
$(document).ready(function(){
	$("#treeOrg").show();
	$("#org").addClass("effect");
	$("#listOrganization").addClass("effect");
});
</script>

</body>

</html>