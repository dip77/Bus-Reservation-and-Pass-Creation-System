<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<link rel="icon" href="Gujjubus-photos/logo.ico" /></head>

<body>
<%@include file="Header.jsp"%>
<form action="UserPassWordResetServlet?id=${param.id}" method="post">
		<div class="row">
							<div class="col-lg-8">
								<div class="col-sm-3">
									<font size="+1"  >New Password:</font>
								</div>
								<div class="col-md-9">
									<input type="password" class="form-control" name="pwdpassword"
										id="txtpassword" maxlength="30" placeholder="Create password"
										value="${param.pwdpassword}" />
										<font color="red"><b>${msgpassword}</b></font>
								</div>
							</div>
						</div>
						<br /> <br />
						<div class="row">
							<div class="col-lg-8">
								<div class="col-sm-3">
									<font size="+1"  >Re-Enter New
										Password:</font>
								</div>
								<div class="col-md-9">
									<input type="password" class="form-control" name="pwdcpassword"
										id="txtpassword" maxlength="30"
										placeholder="Re-enter password" value="${param.pwdcpassword}" />
										<font color="red"><b>${msgcpassword}</b></font>

								</div>
								<input type="submit" value="change password"></div></div>
</form>
</body>
</html>