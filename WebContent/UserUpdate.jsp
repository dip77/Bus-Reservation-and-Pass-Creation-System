
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.digimation.gujjubus.bean.UserBean"%>
<%@page import="com.digimation.gujjubus.dao.CityDAO"%>
<%@page import="com.digimation.gujjubus.bean.CityBean"%>
<%@page import="java.util.ArrayList"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>User Update</title>
<link rel="icon" href="Gujjubus-photos/logo.ico" /></head>
<body class="col-*-*">
	<%@include file="HomePage.jsp"%>
	<div class="col-lg-6">
		<form action="UserValidateServlet?id=${param.id}" method="post">
			<br />
			<div class="col-*-*">
				<div class="container">
					<div class="row">

						<div class="col-lg-8">
							<div class="col-sm-3">
								<font size="+1"  >Name:</font>
							</div>
							<div class="col-md-3">
								<input type="text" id="txtfirstName" name="txtfirstName"
									class="form-control" maxlength="15" placeholder="First Name"
									value="${userBean.firstName}" /><font color="red"><b>${msgfirstName}</b></font>
							</div>
							<div class="col-md-3">
								<input type="text" name="txtmiddleName" id="txtmiddleName"
									maxlength="15" placeholder="Enter Middle Name"
									class="form-control" value="${userBean.middleName}" /><font color="red"><b>${msgmiddlename}</b></font>
							</div>
							<div class="col-md-3">
								<input type="text" name="txtlastName" id="txtlastName"
									placeholder="Enter last" maxlength="15" class="form-control"
									value="${userBean.lastName}" /><font color="red"><b>${msglastname}</b></font>
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

								<input type="text" name="txtemail" id="txtemail" maxlength="30"
									class="form-control" placeholder="Enter Email"
									value="${userBean.email}" /><font color="red"><b>${msgemail}</b></font>
							</div>
						</div>
						<br /> <br /> <br />
						<div class="row">
							<div class="col-lg-8">
								<div class="col-sm-3">
									<font size="+1"  >Password:</font>
								</div>
								<div class="col-md-9">
									<input type="password" name="pwdpassword" id="txtpassword"
										maxlength="30" placeholder="Create password"
										class="form-control" value="${userBean.password}" Disabled /><font color="red"><b>${msgpassword}</b></font>
								</div>
							</div>
						</div>

						<br /> <br />
						<div class="row">
							<div class="col-lg-8">
								<div class="col-sm-3">
									<font size="+1"  >Mobile Number:</font>
								</div>
								<div class="col-md-9">

									<input type="text" name="txtmobile" id="txtmobile"
										maxlength="10" placeholder="Enter mobile number"
										class="form-control" value="${userBean.mobile}" />
										<font color="red"><b>${msgmobile}</b></font>
								</div>
							</div>
						</div>

						<br />
						<%
							String gen = "${userBean.gender}", ml = "", fml = "";
							if (gen != null) {
								if (gen.equals("male"))
									ml = "checked";
								else
									fml = "checked";
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
											value="male" <%=ml%> /> <font  >Male</font>
									</div>
									<div class="col-sm-5">

										<input type="radio" name="rdogender" id="rdogender"
											value="female" <%=fml%> /> <font  >Female</font>
									</div>
									<font color="red"><b>${msggender}</b></font>
								</div>
							</div>
						</div>


						<br /> <br />
						<div class="row">
							<div class="col-lg-8">
								<div class="col-sm-3">
									<font size="+1"  >Is Active:</font>
								</div>
								<%
									UserBean userBean = (UserBean) request.getAttribute("userBean");
									String y = "", n = "";
									if (userBean.getIsActive().equals("y"))
										y = "checked";
									else
										n = "checked";
								%>

								<div class="col-md-4">
									<div class="col-sm-5">
										<input type="radio" name="rdoactive" value="y" <%=y%> /> <font
											 >Yes</font>
									</div>
									<div class="col-sm-5">

										<input type="radio" name="rdoactive" value="n" <%=n%> /> <font
											 >No</font>
									</div>

								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-lg-8">
								<div class="col-sm-3">
									<font size="+1"  >Address:</font>
								</div>
								<div class="col-md-9">

									<textarea rows="3" cols="18" name="txtaddress"
										class="form-control">${userBean.address }
	</textarea>
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
										<%
											ArrayList<CityBean> cityBeansList = new CityDAO().getCityList();
											int type = userBean.getCityId();
											for (int i = 0; i < cityBeansList.size(); i++) {

												String tmp = "unselected";
												if (cityBeansList.get(i).getCityId() == type)
													tmp = "selected";
										%>


										<option value=<%=cityBeansList.get(i).getCityId()%> <%=tmp%>><%=cityBeansList.get(i).getCityName()%></option>
										<%
											}
										%>
									</select><font color="red"><b>${msgcity}</b></font>

								</div>
							</div>
						</div>
						<br />
						<div class="row">
							<div class="col-lg-8">
								<div class="col-lg-5">
					<input type="submit" class="gujju-btn gujju-theme " onclick="Validation();" />
				</div>
				<div class="col-md-4">
					<input type="reset" class="gujju-btn gujju-green " value="Clear" />
				</div>
							</div>

						</div>

					</div>
				</div>
			</div>
		</form>
	</div>
	 
</body>
</html>
