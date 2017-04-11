<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Organization Insert</title>
 



	
<link rel="icon" href="Gujjubus-photos/logo.ico" /></head>
<body>
<%@include file="HomePage.jsp" %>

		<div class="col-lg-6">
	<form action="OrganizationInsertServlet" method="post">
		<br /> <br />
		<div class="container">
			<div class="row">
				<div class="col-lg-10">
					<label class="col-sm-5"><font  
						size="+1">Organization name</font> </label>
					<div class="col-lg-6">
						<input type="text" size="30" maxlength="50" class="form-control"
							placeholder="Organization Name" name="txtOrgName"
							value="${param.txtOrgName}"><font color="red" ><b>${msgorgname}</b></font>
					</div>
				</div>
				<br /> <br />
				<div class="row">
					<div class="col-lg-10">
						<label class="col-sm-5"><font  
							size="+1">Organization Address:</font> </label>
						<div class="col-lg-6">
							<input type="text" class="form-control" maxlength="50"
								placeholder="Organization Address" name="txtOrgAddress"
								value="${param.txtOrgAddress}"><font color="red" ><b>${msgorgadd}</b></font>
						</div>
					</div>
				</div>
				<br /> <br /> <br /> <br />

				<div class="col-lg-5">
					<input type="submit" class="gujju-btn gujju-theme " />
				</div>
				<div class="col-md-4">
					<input type="reset" class="gujju-btn gujju-green " value="Clear" />
				</div>
</div></div>
	</form>
	
</div>
<script>
$(document).ready(function(){
	$("#treeOrg").show();
	$("#org").addClass("effect");
	$("#addOrganization").addClass("effect");
});
</script>


</body>
</html>