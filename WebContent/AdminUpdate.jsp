<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.digimation.gujjubus.bean.AdminBean"%>
<%@page import="com.digimation.gujjubus.dao.CityDAO"%>
<%@page import="com.digimation.gujjubus.bean.CityBean"%>
<%@page import="java.util.ArrayList"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<noscript>
	<div style="color: #FF0000">place enable java script</div>
</noscript>
<script>
	function validation() {
		var lastName = document.forms["Registration"]["txtlastName"].value;
		var firstName = document.forms["Registration"]["txtfirstName"].value;
		var middleName = document.forms["Registration"]["txtmiddleName"].value;
		var flag = true;
		if (firstName == null || firstName == "") {
			document.getElementById("error").innerHTML = "Enter first Name";
			flag = false;
		}
		if (lastName == null || lastName == "") {
			document.getElementById("lastName").innerHTML = "Enter Last Name";
			flag = false;
		}
		if (lastName == null || lastName == "") {
			document.getElementById("lastName").innerHTML = "Enter Last Name";
			flag = false;
		}
		if (flag == false) {
			return false;
		} else {
			return true;
		}
	}
</script>


<title>Admin Update</title>



<noscript>
	<div style="color: #FF0000" class="text-warning">place enable
		java script</div>
</noscript>

<link rel="icon" href="Gujjubus-photos/logo.ico" /></head>
<body class="col-*-*">
	<br />

	<%@include file="HomePage.jsp"%>
	<div class="col-lg-6">
		<form action="AdminValidateServlet?id=${param.id}" method="post"
			name="Registration">

			<div class="container">
				<div class="row">
					<label class="col-sm-2"> <font size="+1">Name:</font>
					</label>
					<div class="col-sm-2">
						<input type="text" id="txtfirstName" class="form-control"
							name="txtfirstName" maxlength="15" placeholder="First Name"
							value="${adminBean.firstName}" /><font color="red"><b>${msgfirstname}</b>
						</font>
					</div>

					<div class="col-sm-2">
						<input type="text" class="form-control" name="txtmiddleName"
							id="txtmiddleName" maxlength="15" placeholder="Middle Name"
							value="${adminBean.middleName}" /> <font color="red"><b>${msgmiddlename}</b>
						</font>
						<div id="middleName"></div>
					</div>

					<div class="col-sm-2">
						<input type="text" class="form-control" name="txtlastName"
							id="txtlastName" placeholder="Enter last" maxlength="15"
							value="${adminBean.lastName}" /><font color="red"><b>${msglastname}</b>
						</font>
						<div id="lastName"></div>
					</div>

				</div>
				<br />
				<div class="row">
					<label class="col-sm-2"> <font size="+1">Email
							:</font> </label>

					<div class="col-lg-6">
						<input type="text" name="txtemail" class="form-control"
							id="txtemail" maxlength="30" placeholder="Example@gujjubus.com"
							value="${adminBean.email}" /><font color="red"><b>${msgemail}</b>
						</font>
						<div id="middleName"></div>
					</div>
				</div>
				<br />
				<div class="row">
					<label class="col-sm-2"> <font size="+1">Password
							:</font> </label>

					<div class="col-lg-6">
						<input type="password" name="pwdpassword" id="txtpassword"
							maxlength="30" placeholder="Create password"
							value="${adminBean.password}" class="form-control"
							readonly="readonly" /><font color="red"><b>${msgpassword}</b>
						</font>
						<div id="middleName"></div>
					</div>
				</div>
				<br /> <br />
				<div class="row">
					<div class="col-lg-8">
						<label class="col-sm-3"><font size="+1">
								Gender: </font> </label>
						<%
							AdminBean adminBean = (AdminBean) request.getAttribute("adminBean");
							String gen = adminBean.getGender();
							String ml = "", fml = "";
							if (gen.equals("male"))
								ml = "checked";
							else
								fml = "checked";
						%>

						<div class="col-md-6">
							<div class="col-sm-5">
								<input type="radio" name="rdogender" id="rdogender" value="male"
									<%=ml%> /> <font>Male</font>
							</div>
							<div class="col-sm-5">
								<input type="radio" name="rdogender" id="rdogender"
									value="female" <%=fml%> /> <font>Female</font> <font
									color="red"><b> ${msggender}</b>
								</font>
							</div>
						</div>
					</div>
				</div>
				<br />
				<div class="row">
					<label class="col-sm-2"> <font size="+1">City:</font>
					</label>

					<div class="col-lg-6">

						<select name="selcity" class="form-control" id="txtbusdepo">
							<option value="0" selected="selected">select city</option>
							<%
								ArrayList<CityBean> cityBeansList = new CityDAO().getCityList();
								int type = adminBean.getCityId();
								for (int i = 0; i < cityBeansList.size(); i++) {

									String tmp = "unselected";
									if (cityBeansList.get(i).getCityId() == type)
										tmp = "selected";
							%>


							<option value=<%=cityBeansList.get(i).getCityId()%> <%=tmp%>><%=cityBeansList.get(i).getCityName()%></option>
							<%
								}
							%>
						</select><font color="red" ><b>${msgcity}</b></font>


					</div>
				</div>

				<br />

				<div class="row">
					<div class="col-lg-8">
						<label class="col-sm-3"><font size="+1">
								Is Active: </font> </label>

						<div class="col-md-4">
							<%
								String y = "", n = "";
								if (adminBean.getIsActive().equals("y"))
									y = "checked";
								else
									n = "checked";
							%>

							<div class="col-sm-5">
								<input type="radio" name="rdoactive" value="y" <%=y%> /> <font>Yes</font>
							</div>
							<div class="col-sm-5">
								<input type="radio" name="rdoactive" value="n" <%=n%> /> <font>No</font>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-5">
					<input type="submit" class="gujju-btn gujju-theme " />
				</div>
				<div class="col-md-4">
					<input type="reset" class="gujju-btn gujju-green " value="Clear" />
				</div>
			</div>
		</form>
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
