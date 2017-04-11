<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bus Type Update</title>




<script src="Gujjubus-javaScript/header/Header.js"></script>

<noscript>
	<div style="color: #FF0000">place enable java script</div>
</noscript>

<link rel="icon" href="Gujjubus-photos/logo.ico" /></head>
<body class="col-*-*">
	<%@include file="HomePage.jsp"%>
	<div class="col-lg-6">
		<form action="BusTypeValidateServlet?id=${param.id}" method="post">
			<div class="container">
				<div class="row">
					<div class="col-lg-10">
						<label class="col-sm-3"><font size="+1">Bus Type :</font>
						</label>
						<div class="col-lg-6">
							<input type="text" size="30" maxlength="7" name="txtBusTypeName"
								value="${busTypeBean.busType}" class="form-control"><font
								color="red"><b>${msgbustype}</b>
							</font>
						</div>

						<div class="col-lg-5">
							<input type="submit" class="gujju-btn gujju-theme " />
						</div>
						<div class="col-md-4">
							<input type="reset" class="gujju-btn gujju-green "
								value="Clear" />
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	<script>
		$(document).ready(function() {
			$("#treeBus").show();
			$("#treeBustype").show();
			$("#addBustype").addClass("effect");
			$("#Bustype").addClass("effect");
			$("#Bus").addClass("effect");
			$("#addBus").addClass("effect");
		});
	</script>

</body>
</html>