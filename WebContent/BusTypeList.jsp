<%@page import="com.digimation.gujjubus.bean.BusTypeBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bus Type List</title>



<link rel="icon" href="Gujjubus-photos/logo.ico" /></head>
<body class="col-*-*">
<%@include file="HomePage.jsp" %>



		<div class="container">
			<%

ArrayList<BusTypeBean> listOfBusTypeBeans=(ArrayList)request.getAttribute("listofbustype");
if(listOfBusTypeBeans!=null)
%>
<font size="+3" color="red"  class=" alert-warning">
${msgbuscat}
</font>
<font size="+3" color="red"  class=" alert-info"><%="<br>"+listOfBusTypeBeans.size()+" records found" %></font>


			<form>
				<div class="col-*-*">
	<div class="col-lg-9">
					<table class="table-hover table gujju-card-4">
						<thead class="gujju-theme">
							<tr>
		 						<th>Bus Type</th>
								<th colspan="2">Action</th>
							</tr>
						</thead>
						<tbody>
							<% for(int i=0;i<listOfBusTypeBeans.size();i++)
	{
	
		BusTypeBean listOfBusTypeBean =listOfBusTypeBeans.get(i);	
		
%>

							<tr>
								<td><%= listOfBusTypeBean.getBusType()%></td>
								<td><a
									href="BusTypeUpdateServlet?id=<%=listOfBusTypeBean.getBusTypeId()%>"><img
										src="Gujjubus-photos/edit.ico" height="30" width="30" /> </a> <a
									href="BusTypeDeleteServlet?id=<%=listOfBusTypeBean.getBusTypeId()%>"><img
										src="Gujjubus-photos/Recycle Bin.ico" height="30" width="30" />
								</a></td>
							</tr>
							<% } %>
						</tbody>
					</table>
				</div>
			</form>
		</div>
	</div>
<script >
$(document).ready(function(){
	$("#treeBus").show();
	$("#treeBustype").show();
	
	$("#listBustype").addClass("effect");
	$("#Bustype").addClass("effect");
	$("#bus").addClass("effect");
	$("#listBus").addClass("effect");
});
</script>
</body>
</html>