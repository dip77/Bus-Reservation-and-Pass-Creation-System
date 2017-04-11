<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.digimation.gujjubus.dao.CityDAO"%>
<%@page import="com.digimation.gujjubus.bean.CityBean"%>
<%@page import="java.util.ArrayList"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Registration User</title>
<noscript>
	<div style="color: #FF0000">place enable java script</div>
</noscript>
<style >
</style>
<link rel="icon" href="Gujjubus-photos/logo.ico" /></head>

<body class="col-*-*">
	<%@include file="HomePage.jsp"%>
	<div class="row">
	<div class="col-lg-6">
		<form action="UserInsertServlet" method="post">
			<br />
				<div class="container">
					<div class="row">
						<div class="col-lg-8">
							<div class="col-sm-3">
								<font size="+1"  >Name:</font>
							</div>
							<div class="col-md-3">
								<input type="text" class="form-control" class="form-control"
									id="txtfirstName" name="txtfirstName" maxlength="15"
									placeholder="First Name" value="${param.txtfirstName}" />
									
									<font color="red" size="-2">${msgfirstname}</font>
							</div>
							<div class="col-md-3">
								<input type="text" class="form-control" name="txtmiddleName"
									id="txtmiddleName" maxlength="15"
									placeholder="Enter Middle Name" value="${param.txtmiddleName}" />
									<font color="red" size="-2">${msgmiddlename}</font>
							</div>
							<div class="col-md-3">
								<input type="text" class="form-control" name="txtlastName"
									id="txtlastName" placeholder="Enter last" maxlength="15"
									value="${param.txtlastName}" />
									
									<font color="red" size="-2">${msglastname}</font>
							</div>
						</div>
					</div>
					<br />
					<div class="row">
						<div class="col-lg-8">
							<div class="col-sm-3">
								<font size="+1"  >Email:</font>
							</div>
							<div class="col-md-9">

								<input type="text" class="form-control" name="txtemail"
									id="txtemail" maxlength="30" placeholder="Enter Email"
									value="${param.txtemail}" />
									<font color="red" size="-2">${msgemail}</font>

							</div>
						</div>
						<br /><br />
						<div class="row">
							<div class="col-lg-8">
								<div class="col-sm-3">
									<font size="+1">Password:</font>
								</div>
								<div class="col-md-9">
									<input type="password" class="form-control" name="pwdpassword"
										id="txtpassword" maxlength="30" placeholder="Create password"
										value="${param.pwdpassword}" />
										<font color="red" size="-2">${msgpassword}</font>
								</div>
							</div>
						</div>

						<br />
						<div class="row">
							<div class="col-lg-8">
								<div class="col-sm-3">
									<font size="+1"  >Conform Password :</font>
								</div>
								<div class="col-md-9">
									<input type="password" class="form-control" name="pwdcpassword"
										id="txtpassword" maxlength="30"
										placeholder="Re-enter password" value="${param.pwdcpassword}" />
										<font color="red" size="-2">${msgcpassword}</font>

								</div>
							</div>
						</div>

						<br />
						<div class="row">
							<div class="col-lg-8">
								<div class="col-sm-3">
									<font size="+1"  >Mobile Number:</font>
								</div>
								<div class="col-md-9">
									<input type="text" name="txtmobile" class="form-control"
										id="txtmobile" maxlength="10"
										placeholder="Enter mobile number" value="${param.txtmobile}" />
										<font color="red" size="-2">${msgmobile}</font>
								</div>
							</div>
						</div>

						
						<% String gen=request.getParameter("rdogender"),ml="",fml="";
	if(gen!=null)
	{
		if(gen.equals("male"))
			ml="checked";
		else
			fml="checked";
	}
	%>

						<div class="row">
							<div class="col-lg-8">
								<div class="col-sm-3">
									<font size="+1"  >Gender:</font>
								</div>
								<div class="col-md-4">
									<div class="col-sm-5">
										<input type="radio" name="rdogender" id="rdogender"
											value="male" <%=ml %> /> <font  >Male</font>
									</div>
									<div class="col-sm-7">

										<input type="radio" name="rdogender" id="rdogender"
											value="female" <%=fml %> /> <font  >Female</font>
									</div>
									<font color="red" size="-2">${msggender}</font>
								</div>
							</div>
						</div>

						<br />
						<div class="row">
							<div class="col-lg-8">
								<div class="col-sm-3">
									<font size="+1"  >Address:</font>
								</div>
								<div class="col-md-9">

									<textarea rows="3" class="form-control" cols="18"
										name="txtaddress">
										${ param.txtaddress }
							</textarea>
									<font color="red" size="-2">${msgaddress}</font>
								</div>
							</div>
						</div>

						<br />
						<div class="row">
							<div class="col-lg-8">
								<div class="col-sm-3">
									<font size="+1"  >City:</font>
								</div>
								<div class="col-md-9">

									<select name="selcity" id="txtbusdepo" class="form-control">
										<option value="0" selected="selected">select city</option>
										<% ArrayList<CityBean>  cityBeansList=new CityDAO().getCityList();

for(int i=0;i<cityBeansList.size();i++)
{

	String tmp="unselected";
	String type=request.getParameter("selcity");
	if(type==null)
	tmp="unselected";
	else if(cityBeansList.get(i).getCityId()==Integer.parseInt(type))
	tmp="selected";


%>


										<option value=<%=cityBeansList.get(i).getCityId()%> <%=tmp %>><%=cityBeansList.get(i).getCityName() %></option>
										<% } %>
									</select>
									<font color="red" size="-2">${msgcity}</font>

								</div>
							</div>
						</div>
						<br />
						<div class="row">
						<div class="col-lg-5">
					<input type="submit" class="gujju-btn gujju-theme " onclick="Validation();" />
				</div>
				<div class="col-md-4">
					<input type="reset" class="gujju-btn gujju-green " value="Clear" />
				</div>
						</div>

					</div>
				</div>
		</form>
	</div>
</div>
	<script>
$(document).ready(function(){
	$("#treeUser").show();
	$("#Passtype").addClass("effect");
	$("#User").addClass("effect");
	$("#addUser").addClass("effect");
});
</script>

</body>
</html>
