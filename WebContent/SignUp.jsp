<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.digimation.gujjubus.dao.CityDAO"%>
<%@page import="com.digimation.gujjubus.bean.CityBean"%>
<%@page import="java.util.ArrayList"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Registration User</title>
<link rel="icon" href="Gujjubus-photos/logo.ico" />
<style >
input
{
text-transform: capitalize;
}
</style>
</head>
<body class="col-*-*">
	<%@include file="Header.jsp"%>
		<form action="UserInsertServlet?id=user" method="post"
			class="gujju-animation-top " >
			<div class="container gujju-card-8">
				<div class="row" style="text-align: center;">
					<h1 class="text-info">
						Registration <span class="fa-user-plus fa"></span>
					</h1>
				</div>
				<br />
				<div class="row ">
					<div class="col-lg-8">
						<div class="col-sm-3">
							<font size="+1">Name:</font>
						</div>
						<div class="col-md-3">
							<input type="text" class="form-control" class="form-control"
								id="txtfirstName" name="txtfirstName" maxlength="15"
								placeholder="First Name" value="${param.txtfirstName}"  required/> <font
								color="red">${msgfirstname} </font>
						</div>
						<div class="col-md-3">
							<input type="text" class="form-control" name="txtmiddleName"
								id="txtmiddleName" maxlength="15" placeholder="Middle Name"
								value="${param.txtmiddleName}" required/> <font color="red" >${msgmiddlename}
							</font>
						</div>
						<div class="col-md-3">
							<input type="text" class="form-control" name="txtlastName"
								id="txtlastName" placeholder="Last Name" maxlength="15"
								value="${param.txtlastName}" required/> <font color="red">${msglastname}
							</font>
						</div>
					</div>
				</div>
				<br />
				<div class="row">
					<div class="col-lg-8">
						<div class="col-sm-3">
							<font size="+1">Email:</font>
						</div>
						<div class="col-md-9">

							<input type="email" class="form-control" name="txtemail"
								id="txtemail" maxlength="30" placeholder="Enter Email"
								value="${param.txtemail}" required/><font color="red">${msgemail}
							</font>
						</div>
					</div>
					<br /> <br /> <br />
					<div class="row">
						<div class="col-lg-8">
							<div class="col-sm-3">
								<font size="+1">Password:</font>
							</div>
							<div class="col-md-9">
								<input type="password" class="form-control" name="pwdpassword"
									id="txtpassword" maxlength="30" placeholder="Create password"
									value="${param.pwdpassword}" required/> <font color="red">${msgpassword}
								</font>
							</div>
						</div>
					</div>

					<br /> <br />
					<div class="row">
						<div class="col-lg-8">
							<div class="col-sm-3">
								<font size="+1">Conform Password:</font>
							</div>
							<div class="col-md-9">
								<input type="password" class="form-control" name="pwdcpassword"
									id="txtpassword" maxlength="30" placeholder="Re-enter password"
									value="${param.pwdcpassword}" required/> <font color="red">${msgcpassword}
								</font>

							</div>
						</div>
					</div>

					<br />
					<div class="row">
						<div class="col-lg-8">
							<div class="col-sm-3">
								<font size="+1">Mobile Number:</font>
							</div>
							<div class="col-md-9">

								<input type="text" name="txtmobile" class="form-control"
									id="txtmobile" maxlength="10" placeholder="Enter mobile number"
									value="${param.txtmobile}" pattern="[1-9]{10}"/><font color="red">${msgmobile}-
								</font>
							</div>
						</div>
					</div>

					<br />
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
								<font size="+1">Gender:</font>
							</div>
							<div class="col-lg-4">
									<label class="gujju-checkbox">
									 <input type="radio" name="rdogender" id="rdogender"
										value="male" <%=ml %>  checked />
											<div class="gujju-checkmark"></div>
											 Male 
									</label> 
									<label class="gujju-checkbox">
									 <input
											type="radio" name="rdogender" id="rdogender"
										value="female" <%=fml %> />
												<div class="gujju-checkmark"></div>
												 Female 
									</label>
									<font color="red">${msggender} </font>
						</div>
					</div>

					<br />
									<br />
					<div class="row">
						<div class="col-lg-8">
							<div class="col-sm-3">
								<font size="+1">&emsp;Address:</font>
							</div>
							<div class="col-md-9">

								<textarea rows="2" class="form-control" cols="5"
									name="txtaddress" required>
										${ param.txtaddress }
							</textarea>
								<font color="red">${msgaddress} </font>
							</div>
						</div>
					</div>

					<br />
					<div class="row">
						<div class="col-lg-8">
							<div class="col-sm-3">
								<font size="+1">&emsp;City:</font>
							</div>
							<div class="col-md-9">

								<select name="selcity" id="txtbusdepo" class="form-control" required>
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
								</select> <font color="red">${msgcity} </font>

							</div>
						</div>
					</div>
					<br />
					<div class="row">
						<div class="col-lg-8">
							<div class="col-md-5">
								<input type="submit" class="gujju-theme  gujju-blockquote gujju-btn "
									style="margin-left: 190px;" />
							</div>
							<input type="reset" class="gujju-blockquote  gujju-btn gujju-green" />
						</div>
<br></br>
					</div>

				</div>
			</div>
	</div>	</form>
 	<%@include
		file="Footer.jsp"%> 
 	
<script>
			$(document).ready(function() {
				$("#signup").removeClass("gujju-blue gujju-card-24");
				$("#signup").addClass("gujju-theme-d2 gujju-card-24");
				 
			});
			</script>

</body>
	
</html>
