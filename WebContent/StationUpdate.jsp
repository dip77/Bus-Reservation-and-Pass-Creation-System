<%@page import="com.digimation.gujjubus.dao.CityDAO"%>
<%@page import="com.digimation.gujjubus.bean.CityBean"%>
<%@page import="com.digimation.gujjubus.dao.StationDAO"%>
<%@page import="com.digimation.gujjubus.bean.StationBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Station Update</title>






<noscript>
	<div style="color: #FF0000">place enable java script</div>
</noscript>
<link rel="icon" href="Gujjubus-photos/logo.ico" /></head>
<body class="col-*-*">
	<%@include file="HomePage.jsp"%>
	<div class="col-lg-6">
		<br />
		<div class="container">
			<form action="StationValidateServlet?id=${param.id}" method="post">
				<div class="row">
					<div class="col-lg-10">
						<label class="col-sm-3"><font  
							size="+1"> Station Name</font> </label>
						<div class="col-lg-6">
							<input type="text" name="txtstationName"
								value="${stationBean.stationName}" class="form-control">${msgstationname}
						</div>
					</div>
				</div>
				<br /> <br />
				<div class="row">
					<div class="col-lg-10">
						<label class="col-sm-3"><font  
							size="+1"> city </font> </label>
						<div class="col-lg-6">
							<select name="selstationCity" id="txtbusdepo"
								class="form-control">
								<%
									ArrayList<CityBean> cityBeansList = new CityDAO().getCityList();
									StationBean stationBean = (StationBean) request
											.getAttribute("stationBean");
									int type = stationBean.getCityId();
									for (int i = 0; i < cityBeansList.size(); i++) {

										String tmp = "unselected";
										if (cityBeansList.get(i).getCityId() == type)
											tmp = "selected";
								%>
								<option value=<%=cityBeansList.get(i).getCityId()%> <%=tmp%>><%=cityBeansList.get(i).getCityName()%></option>
								<%
									}
								%>
							</select>
							
							<font color="red"><b>${msgcityname}</b></font>
						</div>
					</div>
					<br /> <br />

					<div class="col-lg-5">
						<input type="submit" class="gujju-btn gujju-theme " />
					</div>
					<div class="col-md-4">
						<input type="reset" class="gujju-btn gujju-green " value="Clear" />
					</div>
				</div>
			</form>
		</div>
	</div>
	<script>
$(document).ready(function(){
	$("#treeStation").show();
	$("#station").addClass("effect");
	$("#addStation").addClass("effect");
});
</script>

</body>
</html>