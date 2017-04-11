<%@page import="com.digimation.gujjubus.bean.PassTypeBean"%>
<%@page import="com.digimation.gujjubus.dao.PassTypeDAO"%>
<%@page import="com.digimation.gujjubus.bean.PassBean"%>
<%@page import="com.digimation.gujjubus.bean.StationBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.digimation.gujjubus.bean.BusBean"%>
<%@page import="com.digimation.gujjubus.dao.StationDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pass Update</title>




<noscript>
	<div style="color: #FF0000">place enable java script</div>
</noscript>

<link rel="icon" href="Gujjubus-photos/logo.ico" /></head>

<body class="col-*-*">
<%@include file="HomePage.jsp" %>
<div class="col-lg-6">
	<div class="container">

		<%!ArrayList<StationBean> stationBeansList;

	PassBean passBeansList;

	ArrayList<PassTypeBean> passTypeBeansList;%>
		<form action="PassValidateServlet?id=${param.id}" method="post">
			<div class="row">
				<div class="col-lg-10">
					<label class="col-sm-3"><font  
						size="+1"> Source</font> </label>
					<div class="col-lg-7">
						<select name="selsource" id="txtbusdepo" class="form-control">
							<%
								stationBeansList = new StationDAO().getStationList();
								PassBean passBean = (PassBean) request.getAttribute("passBean");
								int type = passBean.getSourceId();
								for (int i = 0; i < stationBeansList.size(); i++) {

									String tmp = "unselected";
									if (stationBeansList.get(i).getStationId() == type)
										tmp = "selected";
							%>


							<option value=<%=stationBeansList.get(i).getStationId()%>
								<%=tmp%>><%=stationBeansList.get(i).getStationName()%></option>
							<%
								}
							%>
						</select><font color="red"><b>${msgsource}</b></font>

					</div>
				</div>
			</div>

			<br /> <br />

			<div class="row">
				<div class="col-lg-10">
					<label class="col-sm-3"><font  
						size="+1"> Destination</font> </label>
					<div class="col-lg-7">
						<select name="seldestination" id="txtbusdepo" class="form-control">
							<%
								stationBeansList = new StationDAO().getStationList();
								type = passBean.getDestinationId();
								for (int i = 0; i < stationBeansList.size(); i++) {

									String tmp = "unselected";
									if (stationBeansList.get(i).getStationId() == type)
										tmp = "selected";
							%>

							<option value=<%=stationBeansList.get(i).getStationId()%>
								<%=tmp%>><%=stationBeansList.get(i).getStationName()%></option>
							<%
								}
							%>
						</select><font color="red"><b>${msgdes}</b></font>
					</div>
				</div>
			</div>
			<br /> <br />
			<div class="row">
				<div class="col-lg-10">
					<label class="col-sm-3"><font  
						size="+1"> Pass Type</font> </label>
					<div class="col-lg-7">
						<%
							passTypeBeansList = new PassTypeDAO().getPassTypeList();
							int type1 = passBean.getPassTypeId();
							for (int i = 0; i < passTypeBeansList.size(); i++) {
								String tmp = "unchecked";
								if (passTypeBeansList.get(i).getPassTypeId() == type1)
									tmp = "checked";
						%>
						<input type="radio"
							value=<%=passTypeBeansList.get(i).getPassTypeId()%>
							name="rdopassType" <%=tmp%> />&nbsp;<%=passTypeBeansList.get(i).getPassType()%>
						<%
							}
						%>${msgpasstype} <br /> <br />
						<%
							String y = "", n = "";
							if (passBean.getIsActive().equals("y"))
								y = "checked";
							else
								n = "checked";
						%>
					</div>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-lg-10">
					<label class="col-sm-3"><font  
						size="+1"> Is Active </font> </label>
					<div class="col-lg-7">
						<input type="radio" name="rdoactive" value="y" <%=y%>>yes
						<input type="radio" name="rdoactive" value="n" <%=n%>>no
					</div>
				</div>
			</div>

			<br /> <br /> <br />
			<div class="col-lg-5">
				<input type="submit" class="gujju-btn gujju-theme " />
			</div>
			<div class="col-md-4">
				<input type="reset" class="gujju-btn gujju-green " value="Clear" />
			</div>
		</form>
	</div></div>
<script>
$(document).ready(function(){
	$("#treePass").show();
	$("#treePass").show();
	
	$("#treePassinner").show();
	$("#Passinner").addClass("effect");
	$("#pass").addClass("effect");
	$("#addPass").addClass("effect");
});
</script>

</body>
</html>