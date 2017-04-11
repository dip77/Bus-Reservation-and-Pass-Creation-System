<%@page import="java.io.File"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.ByteArrayOutputStream"%>
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
<link rel="stylesheet"
	href="Gujjubus-css/font-awesome-4.5.0/css/font-awesome.min.css" />
<link rel="stylesheet" href="Gujjubus-css/gujjubus.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PassDetail Detail List</title>

<link rel="icon" href="Gujjubus-photos/logo.ico" /></head>
<body class="col-*-*">
	<%
		PassBean listOfPassDetailBean = (PassBean) session
				.getAttribute("PassBean");

		OrganizationBean orgBean = (OrganizationBean) session
				.getAttribute("orgBean");
		UserBean userBean=(UserBean)session.getAttribute("userBean");
		PassDetailBean passDetailBean = (PassDetailBean) session
				.getAttribute("passDetailBean");
		if (listOfPassDetailBean != null)
	%>

	<form >
		<button onclick="p()" style="margin-left: 600px; position: absolute;"
			class="gujju-blue gujju-btn">
			<i class="fa-print fa"></i>&emsp;<b>Print Pass</b>
		</button>
		<div
			style="margin-top: 30px; background-color: transparent; border:3px; border-color:blue; padding-left: 30px;">
			<div>
				<img src="upload\\QRCode\\<%=userBean.getFirstName() %>.gif" width="100" height="100" /> <font
					face="Jokerman" size="+5" style="margin-top: -10px; color: #2196F3">GujjuBus</font>
			</div>

			<br /> <img alt="photo Not Found"
				src="<%="upload/pass/" + listOfPassDetailBean.getPhoto()%>"
				style="margin-left: 150px; margin-top: -20px; position: absolute;"
				width="120" height="140" />


			<div style="position: absolute; margin-top: 100px;">

				<div style="margin-top: 100px;">
					<div
						style="margin-top: -70px; margin-left: 110px; text-transform: uppercase; word-spacing: 2em;">
						<b><%=userBean.getFirstName()%> <%=userBean.getMiddleName()%>
							<%=userBean.getLastName()%></b>
					</div>
				</div>
				<div style="margin-left: 80px;">
					<b style="weigth: 300px;"><b>Start Date:&emsp;&nbsp;</b> </b>
					<%=new Date().toString().substring(0, 10) + " 2015"%><br /> <b>Pass
						Validity:</b><%=passDetailBean.getValidity() + " months"%>
					<br /> <b>Term Validity: </b><%=listOfPassDetailBean.getTermValidity()%>
				</div>
				<div style="margin-left: 80px">
					<b>Route: &emsp;&emsp;&emsp;</b>
					<%=listOfPassDetailBean.getSource()%>
					-
					<%=listOfPassDetailBean.getDestination()%>
				</div>
				<div style="margin-left: 80px">
					<b>Organization:</b><%=orgBean.getOrganizationName()%>
					<br /> <b>Amount:&emsp;&emsp;</b>
					<%=passDetailBean.getTotalAmount()%>
				</div>
				<br />

				<div style="margin-left: 80px">
					<div>
						<b>Email :</b><%=userBean.getEmail()%><br /> <b>Organization
							Address :</b>
						<%=orgBean.getOrganizationAddress()%>
					</div>

				</div>
				<br /> <br /> <br /> <br />

			</div>
		</div>
	</form>
	<script>
		function p() {
			window.print();
		}
	</script>

</body>
</html>