<%@page import="com.digimation.gujjubus.bean.ScheduleBean"%>
<%@page import="com.digimation.gujjubus.dao.BusDAO"%>
<%@page import="com.digimation.gujjubus.bean.BusBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Schedule Update</title>
<script src="Gujjubus-javaScript/Bootstrapemin/bootstrap.min.js"></script>
<script src="Gujjubus-javaScript/Dropdown/bootstrap.min.js"></script>

<link rel="stylesheet" href="Gujjubus-css/bootstrap.css" />

<noscript>
	<div style="color: #FF0000">place enable java script</div>
</noscript>
<link rel="icon" href="Gujjubus-photos/logo.ico" /></head>
<body class="col-*-*">
<%@include file="HomePage.jsp" %>
	<div class="col-lg-6">
	<form action="ScheduleValidateServlet?id=${param.id}" method="post">
		<div class="container">
			<div class="row">
				<div class="col-lg-10">
					<label class="col-sm-3"><font size="+1"
						 > Bus No</font>
					</label>
					<div class="col-lg-6">
						<select name="selbusNo" class="form-control" id="txtbusdepo">


							<%
								ArrayList<BusBean> busBeansList = new BusDAO().getBusList();

								ScheduleBean scheduleBean = (ScheduleBean) request
										.getAttribute("scheduleBean");
								String type = scheduleBean.getBusNo();
								for (int i = 0; i < busBeansList.size(); i++) {

									String tmp = "unselected";

									if (busBeansList.get(i).getBusNo().equals(type))
										tmp = "selected";
							%>

							<option value=<%=busBeansList.get(i).getBusNo()%> <%=tmp%>><%=busBeansList.get(i).getBusNo()%></option>
							<%
								}
							%>
						</select>
						<font color="red"><b>${msgbusno}</b></font>
					</div>
				</div>
			</div>
			<br />
			<br />
			<div class="col-lg-5">
				<input type="submit" class="gujju-btn gujju-theme " />
			</div>
			<div class="col-md-4">
				<input type="reset" class="gujju-btn gujju-green " value="Clear" />
			</div>
		</div>
	</form>
</div></body>
</html>