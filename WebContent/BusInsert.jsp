<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.digimation.gujjubus.dao.CityDAO"%>
<%@page import="com.digimation.gujjubus.dao.BusCategoryDAO"%>
<%@page import="com.digimation.gujjubus.bean.BusCategoryBean"%>
<%@page import="com.digimation.gujjubus.bean.CityBean"%>
<%@page import="com.digimation.gujjubus.bean.BusTypeBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.digimation.gujjubus.dao.BusTypeDAO"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Bus Inert</title> 
<noscript>
	<div style="color: #FF0000">place enable java script</div>
</noscript>
 <link rel="icon" href="Gujjubus-photos/logo.ico" /></head>
<body class="col-*-*">

<%@include file="HomePage.jsp" %>
<div class="col-lg-6" >
<br />
	<div class="container">
		<%!ArrayList<BusTypeBean> busTypeBeansList;
	ArrayList<BusCategoryBean> busCategoryBeansList;
	ArrayList<CityBean> cityBeansList;
		%>
		<form action="BusInsertServlet" method="post">
			<div class="row">
				<div class="col-lg-10">
					<label class="col-sm-2"><font  
						size="+1">Bus Number</font> </label>
					<div class="col-lg-6">
						<input type="text" name="txtbusNo" placeholder="Bus Number"
							maxlength="12" value="${param.txtbusNo}" id="txtbusNo"
							class="form-control" style="text-transform:uppercase;" /><font color="red" >${msgbusno}</font>
					</div>

				</div>
			</div>

			<div class="row">
				<div class="col-lg-10">
					<label class="col-sm-2"><font  
						size="+1">Bus Type</font> </label>
					<div class="col-lg-2">

						<%
				busTypeBeansList = new BusTypeDAO().getBusTypeList();
				for (int i = 0; i < busTypeBeansList.size(); i++) {
					String tmp = "unchecked";
					String type = request.getParameter("rdobusType");
					if (type == null)
						tmp = "unchecked";
					else if (busTypeBeansList.get(i).getBusTypeId() == Integer
							.parseInt(type))
						tmp = "checked";
			%>

						<input type="radio"
							value=<%=busTypeBeansList.get(i).getBusTypeId()%>
							name="rdobusType" <%=tmp%> /><%=busTypeBeansList.get(i).getBusType()%>
						<%
				}
			%>
					</div>
					<br />
			<font color="red" >${msgbustype}</font>
				</div>
			</div>

			<br />
						<div class="row">
				<div class="col-lg-10">
					<label class="col-sm-2">
					<font  >Bus Category</font> </label>
					<div class="col-lg-9">

						<%
				busCategoryBeansList = new BusCategoryDAO().getBusCategoryList();
				for (int i = 0; i < busCategoryBeansList.size(); i++) {
					String tmp = "unchecked";
					String type = request.getParameter("rdobusCategory");
					if (type == null)
						tmp = "unchecked";
					else if (busCategoryBeansList.get(i).getBusCategoryId() == Integer
							.parseInt(type))
						tmp = "checked";
			%>
						<input type="radio"
							value=<%=busCategoryBeansList.get(i).getBusCategoryId()%>
							name="rdobusCategory" <%=tmp%> /><%=busCategoryBeansList.get(i).getBusCategory()%>
						<%
				}
			%><font color="red" >${msgbuscat}</font>
					</div>
				</div>
			</div>
			
<br />
			<div class="row">
				<div class="col-lg-10">
					<label class="col-sm-2"><font  
						size="+1">Capacity</font> </label>
					<div class="col-lg-6">
						<input type="number" placeholder="Capacity of Bus"
							name="numcapacity" maxlength="3" min="30" max="56" value="${param.numcapacity}" class="form-control" />
							<font color="red" >${msgbuscapacity}</font>
					</div>

				</div>
			</div>
			<br /> 

			<div class="row">
				<div class="col-lg-10">
					<label class="col-sm-2"><font  
						size="+1">Bus Depo</font> </label>
					<div class="col-lg-6">
						<select name="selbusDepo" id="txtbusdepo" class="form-control">
							<option value="0" selected="selected">select city</option>
							<%
							cityBeansList = new CityDAO().getCityList();

							for (int i = 0; i < cityBeansList.size(); i++) {

							String tmp = "unselected";
							String type = request.getParameter("selbusDepo");
							if (type == null)
								tmp = "unselected";
							else if (cityBeansList.get(i).getCityId() == Integer
									.parseInt(type))
								tmp = "selected";
							%>


							<option value=<%=cityBeansList.get(i).getCityId()%> <%=tmp%>><%=cityBeansList.get(i).getCityName()%></option>
							<%
								}
							%>
						</select><font color="red"  >${msgbusdepo}</font>
					</div>

				</div>
			</div>
<br></br>
			<div class="col-lg-5">
				<input type="submit" class="gujju-btn gujju-theme  " />
			</div>
			<div class="col-md-4">
				<input type="reset" class="gujju-btn gujju-green  " value="Clear" />
			</div>
	</form>
	</div>
	<script>
		$(document).ready(function() {
			$("#treeBus").show();
			
			$("#treeBusinner").show();
			$("#Businner").addClass("effect");
			$("#bus").addClass("effect");
			$("#addBus").addClass("effect");
		});
	</script>

</div>
</body>
</html>
