<%@page import="com.digimation.gujjubus.bean.PassDetailBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pass Detail Update</title>

 



 
<link rel="icon" href="Gujjubus-photos/logo.ico" /></head>
<body class="col-*-*">
<%@include file="HomePage.jsp" %>

<div class="col-lg-6">
<form action="PassDetailValidateServlet?id=${param.id}" method="post">

<div class="container">
	<div class="row">
		<div class="col-lg-10">
			<label class="col-sm-3"><font   size="+1">Validity</font></label>
<div class="col-lg-1">
<%
PassDetailBean passDetailBean=(PassDetailBean)request.getAttribute("passDetailBean");

String one="",three="";
int gen=passDetailBean.getValidity();
	if(gen==1)
		one="checked";
	else
		three="checked";

%>

<select name="selvalidity" class="form-control">
<option value=1 <%=one %>>1</option>
<option value=3 <%=three %>>3</option>
</select>
</div>
</div>
</div>
<br />
<div class="row">
		<div class="col-lg-10">
			<label class="col-sm-3"><font   size="+1">Term Validity</font></label>
<div class="col-lg-1">
<%
 gen=passDetailBean.getTermValidity();
String arry[]=new String[4];
	switch(gen)
	{
	case 1:
			arry[0]="selected";
		break;

	case 3:
			arry[1]="selected";
		break;

	case 6:
			arry[2]="selected";
		break;

	case 12:
			arry[3]="selected";
		break;
	}

%>

<select name="seltermvalidity" class="form-control">
<option value=1>1</option>
<option value=3>3</option>
<option value=6>6</option>
<option value=12>12</option>
</select>
</div>
</div>
<br>
<br />
			<div class="col-lg-6">
				<input type="submit" class="gujju-btn gujju-theme " />
			</div>
			<div class="col-lg-6">
				<input type="reset" class="gujju-btn gujju-green " value="Clear" />
			</div>
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
