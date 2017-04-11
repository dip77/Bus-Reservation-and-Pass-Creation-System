<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pass Detail Insert</title>
 



 
 <noscript>
	<div style="color: #FF0000">place enable java script</div>
</noscript>

<link rel="icon" href="Gujjubus-photos/logo.ico" /></head>
<body class="col-*-*">

<%@include file="HomePage.jsp" %>
<div class="col-lg-6"> 	 	    	
<form action="" method="post">
<div class="container">
	<div class="row">
		<div class="col-lg-10">
			<label class="col-sm-4">
				<font   size="+1">
						Number of Month
						</font></label>
						<div class="col-lg-6"> 
<select name="selvalidity" class="form-control">
<option value=0 selected="selected">select number of month</option>
<option value=1>1</option>
<option value=3>3</option>
</select>
</div>
</div>
</div>
<br>	
	<div class="row">
		<div class="col-lg-10">
			<label class="col-sm-4">
				<font   size="+1">
							enter start term date
						</font></label>
						<div class="col-lg-6"> 

<input type="Date" name="txtStartTermDate" value="${param.txtStartTermDate}" class="form-control">
</div></div></div>

<br>	
	<div class="row">
		<div class="col-lg-10">
			<label class="col-sm-4">
				<font   size="+1">
							Pass Start Day
						</font></label>
						<div class="col-lg-6"> 
<input type="radio" name="rdostart" >Today
 <input type="radio" name="rdostart">Tommorow 
 
 </div></div></div>
<br>	
<div class="row">
		<div class="col-lg-10">
			<label class="col-sm-4">
				<font   size="+1">
							Term Validity
						</font></label>
						<div class="col-lg-6"> 

<select name="seltermvalidity" class="form-control">
<option value=0 selected="selected">select term validity [month]</option>
<option value=1>1</option>
<option value=3>3</option>
<option value=6>6</option>
<option value=12>12</option>
</select>
</div></div></div>
<br /> <br />
<div class="row">
		<div class="col-lg-10">
			<label class="col-sm-4">
				<font   size="+1">
						Organization Name
						</font></label>
						<div class="col-lg-6"> 

<input type="text" name="txtorg" value="${param.txtorg}" class="form-control">
</div></div></div>
<br>
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
	$("#treePass").show();
	$("#treePass").show();
	$("#treePassinner").show();
	$("#Passinner").addClass("effect");
	$("#pass").addClass("effect");
	$("#addPass").addClass("effect");
});
</script>

</body>
</html>