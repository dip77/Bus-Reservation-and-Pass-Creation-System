<%@page import="com.digimation.gujjubus.dao.BusDAO"%>
<%@page import="com.digimation.gujjubus.bean.RouteBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.digimation.gujjubus.dao.RouteDAO"%>
<%@page import="com.digimation.gujjubus.bean.BusBean"%>
<%@page import="com.digimation.gujjubus.bean.BusDetailBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bus Detail Update</title>





<noscript>
	<div style="color: #FF0000">place enable java script</div>
</noscript>

<link rel="icon" href="Gujjubus-photos/logo.ico" /></head>
<body class="col-*-*">
	<%@include file="HomePage.jsp"%>
	<div class="col-lg-6">
		<%!
ArrayList<RouteBean> routeBeansList;
BusDetailBean busDetailBean;
ArrayList<BusBean> busBeansList;
%>

		<form action="BusDetailValidateServlet?id=${param.id}" method="post">
			<div class="container">
				<div class="row">
					<div class="col-lg-10">
						<label class="col-sm-3"><font  
							size="+1">Source</font>
						</label>
						<div class="col-lg-7">
							<select name="selsource" id="txtbusdepo" class="form-control">
								<%
busDetailBean=(BusDetailBean)request.getAttribute("busDetailBean");
routeBeansList=new RouteDAO().getRouteList();
String type=busDetailBean.getSource();
for(int i=0;i<routeBeansList.size();i++)
{

	String tmp="unselected";
	 if(routeBeansList.get(i).getSource().equals(type))
	tmp="selected";


%>
								<option value=<%=routeBeansList.get(i).getSourceId()%> <%=tmp %>><%=routeBeansList.get(i).getSource() %></option>
								<% } %>
							</select><font color="red" ><b>${msgsource}</b></font>
						</div>
					</div>
				</div>


				<br />
				<br />
				<div class="row">
					<div class="col-lg-10">
						<label class="col-sm-3"><font  
							size="+1">Destination</font>
						</label>
						<div class="col-lg-7">
							<select name="seldestination" id="txtbusdepo"
								class="form-control">


								<%   

for(int i=0;i<routeBeansList.size();i++)
{

	String tmp="unselected";
	 type=busDetailBean.getDestination();
 if(routeBeansList.get(i).getDestination().equals(type))
	tmp="selected";


%>

								<option value=<%=routeBeansList.get(i).getDestinationId()%>
									<%=tmp %>><%=routeBeansList.get(i).getDestination() %></option>
								<% } %>
							</select><font color="red" ><b>${msgdes}</b></font>
						</div>
					</div>
					<br />
					<br /> <br />
					<br />

					<div class="row">
						<div class="col-lg-10">
							<label class="col-sm-3"><font  
								size="+1">Bus No</font>
							</label>

							<div class="col-lg-7">
								<select name="selbusNo" id="txtbusdepo" class="form-control">


									<%   

busBeansList=new BusDAO().getBusList();
for(int i=0;i<busBeansList.size();i++)
{

	String tmp="unselected";
	 type=busDetailBean.getBusNo();
 if(busBeansList.get(i).getBusNo().equals(type))
	tmp="selected";


%>

									<option value=<%=busBeansList.get(0).getBusNo()%> <%=tmp %>><%=busBeansList.get(i).getBusNo() %></option>
									<% } %>
								</select><font color="red" ><b>${msgbusno}</b></font>

							</div>
						</div>
					</div>

					<br />
					<br />

					<% 
String y="",n="";
if(busDetailBean.getIsAvailable().equals("y"))
	y="checked";
else
	n="checked";
%>

					<div class="row">
						<div class="col-lg-10">
							<label class="col-sm-3"><font  
								size="+1">Is Available</font>
							</label>

							<div class="col-lg-7">


								<input type="radio" name="rdoavailable" value="y" <%=y %>><img
									src="Gujjubus-photos/right.png" height="30" width="30" /> <input
									type="radio" name="rdoavailable" value="n" <%=n %>><img
									src="Gujjubus-photos/Delete.png" height="30" width="30" />
							</div>
						</div>

						<br />
						<div class="col-lg-5">
							<input type="submit" class="gujju-btn gujju-theme " />
						</div>
						<div class="col-md-4">
							<input type="reset" class="gujju-btn gujju-green "
								value="Clear" />
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	<script>
		$(document).ready(function() {
			$("#treeBus").show();
			$("#treeBusdetail").show();
			$("#bus").addClass("effect");
			$("#Busdetail").addClass("effect");
			$("#addBusdetail").addClass("effect");
		});
	</script>
</body>
</html>