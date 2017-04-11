<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.digimation.gujjubus.dao.CityDAO"%>
<%@page import="com.digimation.gujjubus.bean.CityBean"%>
<%@page import="java.util.ArrayList"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Add Admin</title>
 
<link rel="icon" href="Gujjubus-photos/logo.ico" /></head>

<body class="col-*-*">

	<%@include file="HomePage.jsp"%>
	<div class="col-lg-6">
		<div class="container">
			<form action="AdminInsertServlet" method="post" name="Registration">
				<br />
				<div class="row ">
					<label class="col-sm-2"> <font>Name :</font> </label>
					<div class="col-sm-2">
						<input type="text" class="form-control" name="txtfirstName"
							maxlength="15" placeholder="First Name"
							value="${param.txtfirstName}" /> 
						<font color="red"><b>${msgfirstname}</b>
						</font>
					</div>
					<div class="col-sm-2">
						<input type="text" class="form-control" name="txtmiddleName"
							maxlength="15" placeholder="Middle Name"
							value="${param.txtmiddleName}" />
							 <font  style="color: red;"><b>${msgmiddlename}</b></font>
					</div>
					<div class="col-sm-2">
						<input type="text" class="form-control" name="txtlastName"
							maxlength="15" placeholder="Last Name"
							value="${param.txtlastName}" /> <font color="red"><b>${msglastname}</b>
						</font>
					</div>
				</div>
				<br />
				<div class="row">
					<label class="col-sm-2"> <font>Email :</font> </label>

					<div class="col-lg-6">
						<input type="text" class="form-control" name="txtemail"
							placeholder="example@gujjubus.com" maxlength="30"
							value="${param.txtemail}" /> <font color="red"><b>${msgemail
								}</b>
						</font>
					</div>
				</div>
				<br />
				<div class="row">
					<label class="col-sm-2"> <font>Password :</font>
					</label>
					<div class="col-lg-6">
						<input type="password" class="form-control" name="pwdpassword"
							value="${param.pwdpassword}" placeholder="Create Password"
							maxlength="30" /> <font color="red"><b>${msgpassword
								}</b>
						</font>
					</div>
				</div>
				<br />
				<div class="row">
					<label class="col-sm-2"> <font size="+1">Conform
							Password :</font> </label>
					<div class="col-lg-6">
						<input type="password" class="form-control" name="pwdcpassword"
							placeholder="Re-Enter Password" maxlength="30"
							value="${param.pwdcpassword}" /> <font color="red"><b>${msgcpassword
								}</b>
						</font>
					</div>
				</div>
				<br />
				<div class="row">
					<div class="col-lg-8">
						<%
							String gen = request.getParameter("rdogender"), ml = "", fml = "";
							if (gen != null) {

								if (gen.equals("male"))
									ml = "checked";
								else
									fml = "checked";
							}
						%>
						<label class="col-sm-3"><font>Gender: </font>
						</label>
						<div class="col-md-7">
							<div class="col-sm-6">
								<input type="radio" class="radio" name="rdogender" value="male"
									<%=ml%> />
								<lable> <font>Male</font> </lable>
							</div>
							<div class="col-sm-6">
								<input type="radio" class="radio" name="rdogender"
									placeholder="Enter Mobile" <%=fml%> value="female" /> <font>Female</font>
							</div>
						</div>
					</div>
					<font color="red"><b> ${msggender}</b>
					</font>
				</div>

				<br />
				<div class="row">
					<label class="col-sm-2"> <font>City :</font> </label>
					<div class="col-lg-6">
						<select name="selcity" id="txtbusdepo" class="form-control">
							<option value="0">Select City</option>
							<%
								ArrayList<CityBean> cityBeansList = new CityDAO().getCityList();

								if (cityBeansList != null) {

									for (int i = 0; i < cityBeansList.size(); i++) {

										String tmp = "unselected";
										String type = request.getParameter("selcity");
										if (type == null)
											tmp = "unselected";
										else if (cityBeansList.get(i).getCityId() == Integer
												.parseInt(type))
											tmp = "selected";
							%>
							<option value=<%=cityBeansList.get(i).getCityId()%> <%=tmp%>><%=cityBeansList.get(i).getCityName()%></option>
							<%
								}
								}
							%>

						</select> <font color="red"><b>${ msgcity}</b>
						</font>
					</div>
				</div>
				<br />
				<div class="col-lg-5">
					<input type="submit" class="gujju-btn gujju-theme " onclick="Validation();" />
				</div>
				<div class="col-md-4">
					<input type="reset" class="gujju-btn gujju-green " value="Clear" />
				</div>
			</form>
		</div>
	</div>
	<script>
$(document).ready(function(){
	$("#treeRegistration").show();
	$("#addAdmin").addClass("effect");
	$("#registration").addClass("effect");
});
</script>

</body>
</html>
