<%@page import="com.digimation.gujjubus.dao.PassTypeDAO"%>
<%@page import="com.digimation.gujjubus.dao.PassDAO"%>
<%@page import="com.digimation.gujjubus.bean.PassTypeBean"%>
<%@page import="com.digimation.gujjubus.dao.OrganizationDAO"%><%@page
	import="com.digimation.gujjubus.bean.OrganizationBean"%>
<%@page import="com.digimation.gujjubus.bean.UserBean"%>
<%@page import="com.digimation.gujjubus.dao.UserDAO"%>
<%@page import="com.digimation.gujjubus.dao.PassTypeDAO"%>
<%@page import="com.digimation.gujjubus.dao.PassDAO"%>
<%@page import="com.digimation.gujjubus.bean.PassTypeBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.digimation.gujjubus.bean.StationBean"%>
<%@page import="com.digimation.gujjubus.dao.StationDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pass Insert</title>
<link rel="icon" href="Gujjubus-photos/logo.ico" /></head>
<body class="col-*-*">

<%@include file="UserHeader.jsp"%>

		<%!ArrayList<StationBean> routeBeansList;
	ArrayList<PassTypeBean> passTypeBeansList;%>

		<form action="UserPassInsertServlet" method="post"
			enctype="multipart/form-data">

			<div class="container">
		<div class="row"><div class="col-lg-10 text-info fa-user-plus fa" style="font-size: 30px;" align="center">&emsp;New Pass</div></div>
			 	
				<div class="row">
					<div class="col-lg-10">
						<label class="col-sm-4"><font size="+1"> 
								</font> </label>
						<div class="col-lg-6">

							<font color="red" ><b>${msguser}</b></font>
						</div>
					</div>
					<br />
				<br />
</div>
					<div class="row">
						<div class="col-lg-10">
							<label class="col-sm-4"><font size="+1"> Source</font> </label>
							<div class="col-lg-6">
								<select name="selsource" id="txtbusdepo" class="form-control">
									<option value="0" selected="selected">select source</option>
									<%
									routeBeansList = new StationDAO().getStationList();
									for (int i = 0; i < routeBeansList.size(); i++) {
										String tmp = "unselected";
										String type = request.getParameter("selsource");
										if (type == null)
											tmp = "unselected";
										else if (routeBeansList.get(i).getStationId() == Integer
												.parseInt(type))
											tmp = "selected";
								%>
									<option value=<%=routeBeansList.get(i).getStationId()%>
										<%=tmp%>><%=routeBeansList.get(i).getStationName()%></option>
									<%
									}
								%>
								</select><font color="red" ><b>${msgsource}</b></font>
							</div>
						</div>
					</div>
					<br /> <br>
					<div class="row">
						<div class="col-lg-10">
							<label class="col-sm-4"><font size="+1">
									Destination </font> </label>
							<div class="col-lg-6">

								<select name="seldestination" id="txtbusdepo"
									class="form-control">

									<option value="0" selected="selected">select
										destination</option>

									<%
									routeBeansList = new StationDAO().getStationList();

									for (int i = 0; i < routeBeansList.size(); i++) {

										String tmp = "unselected";
										String type = request.getParameter("seldestination");
										if (type == null)
											tmp = "unselected";
										else if (routeBeansList.get(i).getStationId() == Integer
												.parseInt(type))
											tmp = "selected";
								%>

									<option value=<%=routeBeansList.get(i).getStationId()%>
										<%=tmp%>><%=routeBeansList.get(i).getStationName()%></option>
									<%
									}
								%>
								</select><font color="red" ><b>${msgdes}</b></font>
							</div>
						</div>
					</div>
					<br />

					<div class="row">
						<div class="col-lg-10">
							<label class="col-sm-4"><font size="+1"> Pass Type
							</font> </label>
							<div class="col-lg-6">


								<%
								passTypeBeansList = new PassTypeDAO().getPassTypeList();

								for (int i = 0; i < passTypeBeansList.size(); i++) {
									String tmp = "unchecked";
									String type = request.getParameter("rdopassType");
									if (type == null)
										tmp = "unchecked";
									else if (passTypeBeansList.get(i).getPassTypeId() == Integer
											.parseInt(type))
										tmp = "checked";
							%><input type="radio"
									value=<%=passTypeBeansList.get(i).getPassTypeId()%>
									name="rdopassType" <%=tmp%> />&nbsp;<%=passTypeBeansList.get(i).getPassType()%>
								<%
								}
							%><font color="red" ><b>${msgpasstype}</b></font>
							</div>
						</div>
					</div>
					<br />
					<%
					String one = "", three = "", gen = request.getParameter("rdoval");
					if (gen != null) {
						if (gen.equals("1"))
							one = "checked";
						else
							three = "checked";
					}
				%>
					<div class="row">
						<div class="col-lg-10">
							<label class="col-sm-4"><font size="+1"> Pass
									Validity </font> </label>
							<div class="col-lg-6">


								<input type="radio" name="rdoval" value="1" <%=one%>>1
								Months <input type="radio" name="rdoval" value="3" <%=three%>>3
								Months ${msgval}
							</div>
						</div>
					</div>
					<br />

					<%
					gen = request.getParameter("rdostart");
					if (gen != null) {
						if (gen.equals("1"))
							one = "checked";
						else
							three = "checked";
					}
				%>
					<div class="row">
						<div class="col-lg-10">
							<label class="col-sm-4"><font size="+1"> Pass
									Start Day </font> </label>
							<div class="col-lg-6">


								<input type="radio" name="rdostart" value="1" <%=one%>>Today
								<input type="radio" name="rdostart" value="2" <%=three%>>Tommorow
								<font color="red" ><b>${msgday }</b></font>
							</div>
						</div>
					</div>
					<br>

					<%
					gen = request.getParameter("seltermvalidity");
					String arry[] = new String[4];
					if (gen != null) {
						switch (Integer.parseInt(gen)) {

						case 6:
							arry[0] = "selected";
							break;

						case 12:
							arry[1] = "selected";
							break;
						}
					}
				%>

					<div class="row">
						<div class="col-lg-10">
							<label class="col-sm-4"><font size="+1"> Term
									Validity </font> </label>
							<div class="col-lg-6">

								<select name="seltermvalidity" class="form-control">
									<option value=0 selected="selected">select term
										validity [in months]</option>
									<option value=6 <%=arry[0]%>>6</option>
									<option value=12 <%=arry[1]%>>12</option>
								</select> <font color="red" ><b>${msgtermval}</b></font>
							</div>
						
						</div>
					</div>
					<br /> <br>
					
					<div class="row">
						<div class="col-lg-10" id="orglist">
							<label class="col-sm-4"><font size="+1"> Organization </font> </label>
							<div class="col-lg-6">
					  <select name="selorg" class="form-control">
						<option value="0" selected="selected">
							select organization
							<%

ArrayList<OrganizationBean> orgBeansList= new OrganizationDAO().getOrganizationList();
 
for(int i=0;i<orgBeansList.size();i++)
{
	String j=request.getParameter("selorg");
	String tmp="unselected";
	if(j==null)
		tmp="unselected";
	else if(j.equals(orgBeansList.get(i).getOrganizationId()))
		tmp="selected";
	%>
						
						<option value="<%=orgBeansList.get(i).getOrganizationId()%>"
							<%=tmp %>><%=orgBeansList.get(i).getOrganizationName()%></option>

						<% 	
}
%>
					</select>
					
					</div>
						</div>
						<input type="button" id="addorg" class="btn-info  input-sm" 
								value="Add Organization">
					<br /><br />
					<div id="showorg">
						<div class="row">
							<div class="col-lg-10">
								<label class="col-sm-4"><font size="+1">
										Organization Name </font> </label>
								<div class="col-lg-6">
									<input type="text" class="form-control" name="txtorg"
										value="${param.txtorg}"> ${msgorgname}
								</div>

							</div>
						</div>
						<br />
<div class="row">
							<div class="col-lg-10">
								<label class="col-sm-4"><font size="+1">
										Organization Address</font> </label>
								<div class="col-lg-6">

									<textarea name="txtaddress" class="form-control"> ${param.txtaddress}</textarea>
									${msgorgadd}
								</div>
				</div>			</div>
</div>
				<br>
				<div class="row">
					<div class="col-lg-10">
						<label class="col-sm-4"><font size="+1"> Passport
								Size photo</font> </label>
						<div class="col-lg-6">

							<input type="file" name="photo" value="${passBean.photo}">${msgfile}
						</div>
					</div>
				</div>

				<br>

				<div class="col-lg-5">
					<input type="submit" class="gujju-btn gujju-theme " />
				</div>
				<div class="col-md-4">
					<input type="reset" class="gujju-btn gujju-green " value="Clear" />
				</div>
	</div>		</div>
		</form>
	
	<script>
		$(document).ready(function() {
	 	
			$("#addorg").show(300);
			$("#showorg").hide();
			
			$("#addorg").click(function(){
			$("#orglist").hide(300);
			$("#showorg").toggle(300);			
		});
		});
	</script>
	
	 <%@include file="UserFooter.jsp" %>
</body>
</html>