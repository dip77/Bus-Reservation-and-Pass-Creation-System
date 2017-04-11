<%@page import="java.util.ArrayList"%>
<%@page import="com.digimation.gujjubus.bean.BusCategoryBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bus Category LIst</title>
<link rel="icon" href="Gujjubus-photos/logo.ico" /></head>

<body class="col-*-*">
	<%@include file="HomePage.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-lg-9">
				<%
					ArrayList<BusCategoryBean> listOfBusCategoryBeans = (ArrayList) request
							.getAttribute("listofbuscat");
					if (listOfBusCategoryBeans != null)
				%>
				<font size="+3" color="red"  class=" alert-info">
						<b>${msgbuscat}</b>
				</font><br /><br />  
				<font color="red" size="+2" style="height: 160px;" class="alert-info gujju-card-24">
				 <b><%= listOfBusCategoryBeans.size() + " records found"%></b>
				  </font>
				  <br />  <br /> 

						<form>
							<table
								class=" table table-hover table-responsive text-capitalize gujju-card-16">
								<thead class="gujju-theme">
									<tr>
										<th>Bus Category</th>
										<th colspan="2">Action</th>
									</tr>
								</thead>
								<%
							for (int i = 0; i < listOfBusCategoryBeans.size(); i++) {

								BusCategoryBean listOfBusCategoryBean = listOfBusCategoryBeans
										.get(i);
						%>
								<tbody class="text-uppercase">
									<tr>
										<td><%=listOfBusCategoryBean.getBusCategory()%></td>

										<td><a
											href="BusCategoryUpdateServlet?id=<%=listOfBusCategoryBean.getBusCategoryId()%>"><img
												src="Gujjubus-photos/edit.ico" height="30" width="30" /> </a> <a
											href="BusCategoryDeleteServlet?id=<%=listOfBusCategoryBean.getBusCategoryId()%>"><img
												src="Gujjubus-photos/Recycle Bin.ico" height="30" width="30" />
										</a>
										</td>
									</tr>
									<%
								}
							%>
								</tbody>
							</table>
						</form>
			</div>
		</div>
	</div>
	<script>
		$(document).ready(function() {
			$("#treeBus").show();
			$("#bus").addClass("effect");
			$("#treeBuscategory").show();
			$("#Buscategory").addClass("effect");
			$("#listBusCategory").addClass("effect");
		});
	</script>

</body>
</html>