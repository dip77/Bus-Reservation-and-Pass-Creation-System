<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Welcome</title>
 
 



 
<link rel="icon" href="Gujjubus-photos/logo.ico" /></head>
<body class="col-*-*">
<%@include file="HomePage.jsp" %>
<div class="col-lg-6">
	<form action="CityInsertServlet" method="post">
		<div class="container">
			<div class="row">
				<div class="col-lg-10">
					<label class="col-sm-3"><font  
						size="+1"> City name</font>
					</label>
					<div class="col-lg-6">
						<input placeholder="Enter City Name" type="text" size="30" maxlength="30" name="txtCityName"
							value="${param.txtCityName}" class="form-control"><font color="red" ><b>${msgcityname}</b></font><br>
						<br>
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
	</form></div>
	
	<script >
$(document).ready(function(){
	$("#treeCity").show();
	$("#city").addClass("effect");
	$("#addCity").addClass("effect");
});
</script>
	
</body>
</html>
