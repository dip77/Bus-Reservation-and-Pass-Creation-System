<%@page import="com.digimation.gujjubus.bean.CityBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to City List</title>





<link rel="icon" href="Gujjubus-photos/logo.ico" /></head>
<body class="col-*-*">
	<%@include file="HomePage.jsp"%>
	<div class="col-lg-6">
		<div class="container">

			<%
			ArrayList<CityBean> listOfCityBeans = (ArrayList) request
					.getAttribute("listofcity");
			if (listOfCityBeans != null)
		%>
		<font size="+3" color="red"  class=" alert-warning">${msgcity}</font>
<font size="+3" color="red"  class=" alert-info">
			<%="<br>" + listOfCityBeans.size() + " records found"%>
			</font>
			<form>
				<div class="row">
					<div class="col-lg-10">

						<table class="table-hover table gujju-card-4">
							<thead class="gujju-theme">
								<tr>
									<th>City name</th>
									<th colspan="2">Action</th>
								</tr>
							</thead>
							<tbody>
								<%
								for (int i = 0; i < listOfCityBeans.size(); i++) {
									CityBean listOfCityBean = listOfCityBeans.get(i);
							%>
								<tr>
									<td><%=listOfCityBean.getCityName()%></td>
									<td><a
										href="CityUpdateServlet?id=<%=listOfCityBean.getCityId()%>"><img
											src="Gujjubus-photos/edit.ico" height="30" width="30" class="img-rounded" /> </a>
											 <a
										href="CityDeleteServlet?id=<%=listOfCityBean.getCityId()%>" ><img 
											src="Gujjubus-photos/Recycle Bin.ico" height="30" width="30" class="img-rounded"/>
									</a></td>
								</tr>
								<%
								}
							%>
							</tbody>
						</table>
					</div>
				</div>
			</form>
		</div>
	</div>
	<script>
$(document).ready(function(){
	$("#treeCity").show();
	$("#city").addClass("effect");
	$("#listCity").addClass("effect");
});
</script>

</body>
</html>