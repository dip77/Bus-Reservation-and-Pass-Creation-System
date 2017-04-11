<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>





<noscript>
	<div style="color: #FF0000">place enable java script</div>
</noscript>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pass Type Insert</title>
<link rel="icon" href="Gujjubus-photos/logo.ico" /></head>
<body class="col-*-*">
	<%@include file="HomePage.jsp" %> 
<div class="col-lg-6">
	<div class="container">
		<div class="row">

			<form action="PassTypeInsertServlet" method="post">

				<div class="col-lg-10">
					<label class="col-sm-3"><font  
						size="+1"> Pass Type </font>
					</label>
					<div class="col-lg-6">
						<input type="text" size="30" maxlength="7" name="txtPassTypeName"
							value="${param.txtPassTypeName}" class="form-control">
							<font color="red">${msgpasstype}</font><br>
						<br>
					</div>
					<br />
					<div class="col-lg-5">
						<input type="submit" class="gujju-btn gujju-theme " />
					</div>
					<div class="col-md-4">
						<input type="reset" class="gujju-btn gujju-green " value="Clear" />
					</div>
				</div>
			</form>
</div></div></div>
<script>
$(document).ready(function(){
	$("#treePass").show();
	
	$("#treePasstype").show();
	$("#Passtype").addClass("effect");
	$("#pass").addClass("effect");
	$("#addPasstype").addClass("effect");
});
</script>

</body>
</html>
