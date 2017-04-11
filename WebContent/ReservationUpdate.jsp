<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.digimation.gujjubus.dao.UserDAO"%>
<%@page import="com.digimation.gujjubus.bean.UserBean"%>
<%@page import="com.digimation.gujjubus.bean.ReservationBean"%>
<%@page import="com.digimation.gujjubus.dao.BusDAO"%>
<%@page import="com.digimation.gujjubus.bean.BusBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.digimation.gujjubus.dao.RouteDAO"%>
<%@page import="com.digimation.gujjubus.bean.RouteBean"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Registration.jsp User</title>

<script>
	function take() {

		var a = document.createAttribute("min");
		var now = new Date();
		a.value = now.getFullYear() + '-' + (now.getMonth() + 1) + '-'
				+ now.getDate();
		document.getElementById("date").setAttributeNode(a);
	}
</script>





<link rel="icon" href="Gujjubus-photos/logo.ico" /></head>

<body class="col-*-*">
	<%@include file="HomePage.jsp"%>


	<div class="col-lg-6">
		<%!ReservationBean reservationBean;
	ArrayList<BusBean> busBeansList;%>
		<form action="ReservationValidateServlet?id=${param.id}" method="post">

			<br />

			<div class="col-*-*">

				<div class="container">
					<div class="row">
						<div class="col-lg-8">
							<div class="col-sm-3">
								<font size="+1"  >select user :</font>
							</div>
							<div class="col-md-9">
								<select name="seluser" class="form-control">
									<option value="0" selected="selected">Select User
										[Email]</option>
									<%
ArrayList<UserBean> userBeansList= new UserDAO().getUserList();
reservationBean = (ReservationBean) request.getAttribute("reservationBean");
Integer j = reservationBean.getUserId();	
for(int i=0;i<userBeansList.size();i++)
{
	String tmp="unselected";
		if (j == userBeansList.get(i).getUserId())
			tmp = "selected";
%>

									<option value="<%=userBeansList.get(i).getUserId()%>" <%=tmp %>><%=userBeansList.get(i).getEmail()%></option>
									<% 
}
%>
								</select>
								<font color="red"><b>${msguser}</b></font>
							</div>
						</div>
					</div>
					<br />
					<div class="row">
						<div class="col-lg-8">
							<div class="col-sm-3">
								<font size="+1"  >No of Seat:</font>
							</div>
							<div class="col-md-9">
								<input type="text" class="form-control text-capitalize"
									min="1" max="56" maxlength="2" placeholder="No of Seat"
									name="noOfSeat" value="${reservationBean.noOfSeat}" />
								<font color="red"><b>${msgseat}</b></font>
							</div>
						</div>
					</div>
					<br /> <br /> <br />
 
						<div class="row">
							<div class="col-lg-8">
								<div class="col-sm-3">
									<font size="+1"  >Journey Date:</font>
								</div>
								<div class="col-md-9">
									<input type="date" class="form-control" id="date"
										onclick="take()" name="resDate"
										value="<%=reservationBean.getJourneyDate().replaceAll("/", "-")%>" />

								</div>
							</div>
						</div>
						<br /> <br />
							<%
							String y = "", n = "";
							if (reservationBean.getIsCancel().equals("y"))
								y = "checked";
							else
								n = "checked";
						%>

							<div class="row">
								<div class="col-lg-8">
									<div class="col-sm-3">
										<font size="+1"  >Is Cancel:</font>
									</div>
									<div class="col-lg-9">


										<input type="radio" name="rdocancel" value="y" <%=y%> />yes <input
											type="radio" name="rdocancel" value="n" <%=n%> />no
									</div>
								</div>


								<div class="row">
									<div class="col-lg-8">
										<div class="col-md-5">
											<input type="submit" class="btn-primary  btn " />
										</div>
										<input type="reset" class="btn-default btn" />

									</div>
								</div>
							</div>
						</div>
					</div>
		</form>
				</div>

	<script>
		$(document).ready(function() {
			$("#reservation").show();
			$("#treeReservation").show();
			$("#reservation").addClass("effect");
			$("#addReservation").addClass("effect");
			$("#listReservation").addClass("effect");
		});
	</script>
</body>
</html>
