<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<noscript>
	<div style="color: #FF0000">place enable java script</div>
</noscript>



<title>Bus Type Insert</title>

<link rel="icon" href="Gujjubus-photos/logo.ico" /></head>
<body class="col-*-*">



	<%@include file="HomePage.jsp"%>
		<br />
		<form action="BusTypeInsertServlet" method="post">
			<div class="container">
				<div class="row">
					<div class="col-lg-6">
						<label class="col-sm-3"><font size="+1">Bus Type</font> </label>
						<div class="col-lg-5">
							<input type="text" size="30" maxlength="7" class="form-control"
								name="txtBusTypeName" placeholder="Enter Bus Type"
								value="${param.txtBusTypeName}"><font color="red"><b>${msgbustype}</b></font><br>
							<br>
						</div>
					</div>


					<br />
					<div class="col-lg-5">
						<input type="submit" class="gujju-btn gujju-theme " />
					</div>
					<div class="col-md-4">
						<input type="reset" class="gujju-btn gujju-green "
							value="Clear" />
					</div>

				</div>
			</div>
		</form>
	<script>
		$(document).ready(function() {
			$("#treeBus").show();
			$("#treeBustype").show();

			$("#addBustype").addClass("effect");
			$("#Bustype").addClass("effect");
			$("#bus").addClass("effect");
			$("#addBus").addClass("effect");
		});
	</script>

</body>
</html>