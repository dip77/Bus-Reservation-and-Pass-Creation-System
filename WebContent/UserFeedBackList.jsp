<%@page import="com.digimation.gujjubus.bean.FeedbackBean"%>
<%@page import="com.digimation.gujjubus.bean.AdminBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<meta charset="utf-8" />
<head>
<title>AdminList</title>

<link rel="icon" href="Gujjubus-photos/logo.ico" />
</head>
<body class="col-*-*">

	<%@include file="HomePage.jsp"%>

	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-9">
				<%
				ArrayList<FeedbackBean> listOfFeedbackBeans= (ArrayList) request.getAttribute("listoffeedback");
		if (listOfFeedbackBeans != null)
	%>
				<font size="+3" color="red" class=" alert-warning">
					${msgadmin}</font> <br /> <font size="+3" color="red" class=" alert-info">
					<%=listOfFeedbackBeans.size() + " records found"%></font>

				<table id="example" class="display table table-hover gujju-card-16"
					cellspacing="0" width="100%">
					<thead class="gujju-theme text-uppercase">
						<tr>
							<th>Feedback</th>
						</tr>
					</thead>

					<tbody>
						<%
								for (int i = 0; i < listOfFeedbackBeans.size(); i++) {

									FeedbackBean feedbackBean= listOfFeedbackBeans.get(i);
							%>

						<tr>
							<td><%= feedbackBean.getFeedback()%></td>
						</tr>


						<%
								}
							%>

					</tbody>
				</table>
			</div>
		</div>
	</div>
	<script>
		$(document).ready(function() {

			$("#FeedBack").addClass("effect");

		});
	</script>
</body>
</html>
