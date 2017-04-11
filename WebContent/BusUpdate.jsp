<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 

"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.digimation.gujjubus.bean.BusBean"%>
<%@page import="com.digimation.gujjubus.dao.BusDAO"%>
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
<title>Bus Update</title>
<noscript>
	<div class="alert-danger">
		<font size="6">place enable java script</font>
	</div>
</noscript>
<link rel="icon" href="Gujjubus-photos/logo.ico" /></head>
<body class="col-*-*">
	<%@include file="HomePage.jsp"%>
	<div class="col-lg-6">

		<%!ArrayList<BusTypeBean> busTypeBeansList;
	ArrayList<BusCategoryBean> busCategoryBeansList;
	ArrayList<CityBean> cityBeansList;%>

		<div class="container">

			<form action="BusValidateServlet" method="post">


				<br /> <br />
				<div class="row">
					<div class="col-lg-10">

						<label class="col-sm-3"><font  
							size="+1">bus Number:</font> </label>
						<div class="col-lg-6">
							<input type="text" name="txtbusNo" placeholder="Bus Number"
								maxlength="12" class="form-control" value="${busBean.busNo}"
								readonly="readonly" id="txtbusNo" /><font color="red" ><b> ${msgbusno}</b></font>
						</div>
					</div>
				</div>
				<br />
				<div class="row">
					<div class="col-lg-10">

						<label class="col-sm-3"><font  
							size="+1">Bus type :</font> </label>
						<div class="col-lg-6">
							<%
								BusBean busBean = (BusBean) request.getAttribute("busBean");
								busTypeBeansList = new BusTypeDAO().getBusTypeList();
								int type = busBean.getBusTypeId();
								for (int i = 0; i < busTypeBeansList.size(); i++) {
									String tmp = "unchecked";

									if (busTypeBeansList.get(i).getBusTypeId() == type)
										tmp = "checked";
							%>
							<input type="radio"
								value=<%=busTypeBeansList.get(i).getBusTypeId()%>
								name="rdobusType" <%=tmp%> />&nbsp;<%=busTypeBeansList.get(i).getBusType()%>
							<%
								}
							%><font color="red" ><b>${msgbustype}</b></font>
						</div>
					</div>
				</div>
				<br />
				<div class="row">
					<div class="col-lg-10">

						<label class="col-sm-3"><font  
							size="+1">Capacity: </font> </label>
						<div class="col-lg-6">
							<input type="number" min="30" max="55" class="form-control"
								placeholder="Capacity of Bus" name="numcapacity" maxlength="3"
								value="${busBean.capacity}" min=30 max=60 /><font color="red" ><b> ${msgbuscapacity}</b></font>
						</div>
					</div>
				</div>
				<br />

				<div class="row">
					<div class="col-lg-10">

						<label class="col-sm-3"><font  
							size="+1">Bus Category: </font> </label>
						<div class="col-lg-6">
							<%
								busCategoryBeansList = new BusCategoryDAO().getBusCategoryList();
								type = busBean.getBusCategoryId();
								for (int i = 0; i < busCategoryBeansList.size(); i++) {
									String tmp = "unchecked";
									if (busCategoryBeansList.get(i).getBusCategoryId() == type)
										tmp = "checked";
							%>

							<input type="radio" name="rdobusCategory" id="rdobuscategory"
								value="<%=busCategoryBeansList.get(i).getBusCategoryId()%>"
								<%=tmp%>/><%=busCategoryBeansList.get(i).getBusCategory()%>
							<%
								}
							%><font color="red" ><b>${msgbuscat}</b></font>
						</div>
					</div>
				</div>
				<br />
				<div class="row">
					<div class="col-lg-10">

						<label class="col-sm-3"><font  
							size="+1">Bus Depo: </font> </label>
						<div class="col-lg-6">

							<select name="selbusDepo" class="form-control" id="txtbusdepo">

								<%
									cityBeansList = new CityDAO().getCityList();
									type = busBean.getBusDepoId();
									for (int i = 0; i < cityBeansList.size(); i++) {

										String tmp = "unselected";

										if (cityBeansList.get(i).getCityId() == type)
											tmp = "selected";
								%>


								<option value=<%=cityBeansList.get(i).getCityId()%> <%=tmp%>><%=cityBeansList.get

				(i).getCityName()%></option>
								<%
									}
								%>

							</select><font color="red" ><b>${msgbusdepo}</b></font>
						</div>
					</div>
				</div>
				<br /> <br />

				<div class="row">
					<div class="col-lg-10">

						<label class="col-sm-3"><font  
							size="+1">Bus Available : </font> </label>
						<div class="col-lg-6">

							<%
								String avl = busBean.getIsAvailable();
								String tmpy = "", tmpn = "";
								if (avl.equals("y"))
									tmpy = "checked";
								else
									tmpn = "checked";
							%>
							<input type="radio" name="rdoAvalibility" value="y" <%=tmpy%> />Yes
							<input type="radio" name="rdoAvalibility" value="n" <%=tmpn%> />No
							<br /> <br />
						</div>
					</div>
				</div>


				<div class="col-lg-5">
					<input type="submit" class="gujju-btn gujju-theme " />
				</div>
				<div class="col-md-4">
					<input type="reset" class="gujju-btn gujju-green " value="Clear" />
				</div>
			</form>
		</div>
	</div>	<script>
		$(document).ready(function() {
			$("#treeBus").show();
			
			$("#treeBusinner").show();
			$("#Businner").addClass("effect");
			$("#bus").addClass("effect");
			$("#addBus").addClass("effect");
		});
	</script>


</body>

</html>
