<%@page import="java.util.ArrayList"%>
<%@page import="com.digimation.gujjubus.bean.PassTypeBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pass Type Insert</title>




<link rel="icon" href="Gujjubus-photos/logo.ico" /></head>
<body class="col-*-*">
	<%@include file="HomePage.jsp"%>
	<%
		ArrayList<PassTypeBean> listOfPassTypeBeans = (ArrayList) request
				.getAttribute("listofpasstype");
		if (listOfPassTypeBeans != null)
	%>
	<font size="+3" color="red"  class=" alert-warning">
	${msgpasscat}
</font>
<font size="+3" color="red"  class=" alert-info">
	<%="<br>" + listOfPassTypeBeans.size() + " records found"%>
</font>

	<form>
		<div class="container">
			<div class="row">
				<div class="col-lg-9">
					<table class="table-hover table gujju-card-4">
						<thead class="gujju-theme">
							<tr>
								<th>Pass Type</th>
								<th colspan="2">Action</th>
							</tr>
						</thead>
						<tbody>
							<%
							for (int i = 0; i < listOfPassTypeBeans.size(); i++) {

								PassTypeBean listOfPassTypeBean = listOfPassTypeBeans.get(i);
						%>
							<tr>
								<td class="text-uppercase"><%=listOfPassTypeBean.getPassType()%></td>
								<td>
								<a
									href="PassTypeUpdateServlet?id=<%=listOfPassTypeBean.getPassTypeId()%>"><img
										src="Gujjubus-photos/edit.ico" width="30" height="30" />
										
							 </a> <a
									href="PassTypeDeleteServlet?id=<%=listOfPassTypeBean.getPassTypeId()%>"><img
										src="Gujjubus-photos/Recycle Bin.ico" width="30" height="30" />
								</a>
								</td>
								</td>
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
	<script>
		$(document).ready(function() {
			$("#treePass").show();

			$("#treePasstype").show();
			$("#Passtype").addClass("effect");
			$("#pass").addClass("effect");
			$("#listPasstype").addClass("effect");
		});
	</script>

</body>
</html>