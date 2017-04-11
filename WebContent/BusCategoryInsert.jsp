<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bus Category Insert</title>



<link rel="icon" href="Gujjubus-photos/logo.ico" /></head>
<body class="col-*-*">
<%@include file="HomePage.jsp" %>
<div class="col-lg-4">
<form action="BusCategoryInsertServlet" method="post">
<div class="container">
<div class="row">
	<label class="col-md-2">
		<font size="+1"   pointsize="5">
		Bus Category :		
		</font>
	</label>
 <div class="col-md-5">
 		<input type="text" size="30" maxlength="7" name="txtBusCategoryName" class="form-control" value="${param.txtBusCategoryName}">
 </div><font color="red"><b>${msgbuscategory}</b></font>
 <br /><br /> 
 <div class="row">
		<div class="col-lg-5">
					<input type="submit" class="gujju-btn gujju-theme " />
				</div>
				<div class="col-md-4">
					<input type="reset" class="gujju-btn gujju-green " value="Clear" />
				</div>
</div>
</div>
</div>
</form>
</div>
<script >
$(document).ready(function(){
	$("#bus").addClass("effect");
	$("#treeBus").show();
	$("#treeBuscategory").show();
	$("#Buscategory").addClass("effect");
	$("#addBusCategory").addClass("effect");
});
</script>

</body>
</html>