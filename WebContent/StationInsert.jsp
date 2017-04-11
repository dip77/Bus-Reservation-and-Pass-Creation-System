<%@page import="java.util.ArrayList"%>
<%@page import="com.digimation.gujjubus.dao.CityDAO"%>
<%@page import="com.digimation.gujjubus.bean.CityBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Station Insert</title>

<noscript>
	<div style="color: #FF0000">place enable java script</div>
</noscript>



<link rel="icon" href="Gujjubus-photos/logo.ico" /></head>
<body class="col-*-*">
<%@include file="HomePage.jsp" %>


	<div class="col-lg-6">
		<form action="StationInsertServlet">
			<div class="container">
				<div class="row">
					<br />
					<div class="col-lg-10">
						<label class="col-sm-3"> <font  
							size="+1"> Station Name</font> </label>
						<div class="col-lg-6">
							<input type="text" name="txtstationName"
								placeholder="Station Name" value="${param.txtstationName}"
								class="form-control"> 
								<font color="red"><b>${msgstationname}</b></font>
						</div>
					</div>
				</div>
				<br />
				<div class="row">
					<div class="col-lg-10">
						<label class="col-sm-3"> <font  
							size="+1"> city</font> </label>
						<div class="col-lg-6">
							<select name="selstationCity" id="txtbusdepo"
								class="form-control">

								<option value="0" selected="selected">select city</option>
								<%
									ArrayList<CityBean> cityBeansList = new CityDAO().getCityList();

									for (int i = 0; i < cityBeansList.size(); i++) {

										String tmp = "unselected";
										String type = request.getParameter("selstationCity");
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
							</select>
							<font color="red"><b>${msgcityname}</b></font>

						</div>
					</div>
			<br />	<br />
			<div class="row">
	
					<div class="col-lg-5">
						<input type="submit" class="gujju-btn gujju-theme " />
					</div>
					<div class="col-md-4">
						<input type="reset" class="gujju-btn gujju-green " value="Clear" />
	</div>				</div>
				</div>
			</div>
		</form>
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