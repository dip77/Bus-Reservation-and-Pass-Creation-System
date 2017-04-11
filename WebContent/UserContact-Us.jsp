<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//gujjuC//DTD XHTML 1.0 Transitional//EN" "http://www.gujju.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.gujju.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Contact Us</title>

<link rel="icon" href="Gujjubus-photos/logo.ico" />
</head>

<body>
	<%@include file="UserHeader.jsp"%>
	<br />

	<div class="gujju-container ">


		<div class="col-lg-5" style="float: left;">
			<iframe
				src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d29377.821342812917!2d72.59196469999999!3d23.0154115!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x395e9a93fb84129b%3A0x5d9d15a6b0aead8b!2sGujarat+State+Road+Transport+Corporation!5e0!3m2!1sen!2sin!4v1448883151214"
				width="600" height="305" frameborder="0"
				style="border: 0; float: left;"></iframe>
		</div>

		<div style="size: 10; text-align: left; float: right;"
			class="gujju-col m6 gujju gujju-card-2 ">


			<div style="height: 300px; font-size: 24px;">
				<label class="gujju-text-blue"> Contact Us</label><br /> <font
					class=" text-right" face="Times New Roman"><i
					class="gujju-text-blue fa-map-marker fa "></i> Address</font><br /> <font
					face="Times New Roman" size="+1">Central Office, C/O Central
					Workshop GSRTC, Naroda, Gita Mandir,<br /> &em Ahmedabad, Gujarat
					380001</font> <br /> <i class=" gujju-text-blue fa-phone fa"></i> <font
					face="Times New Roman" size="+1">+91 9033037081</font> <br /> <br />
				<i class="gujju-text-blue fa fa-envelope"></i> <a href="#"
					onclick="document.getElementById('id01').style.display='block'">
					<font face="Times New Roman" size="+1">feedback@gujjuBus.com
						<i class=" gujju-margin-16 "> click here</i> </font> </a>
			</div>
		</div>
		<div id="id01" class="gujju-modal">
			<div class="gujju-animate-top gujju-modal-content gujju-card-4">
				<header class="gujju-container gujju-theme"> <span
					onclick="document.getElementById('id01').style.display='none'"
					class="gujju-closebtn gujju-btn gujju-theme ">x</span>
				<h2 style="font-weight: 500;">Feedback</h2>
				</header>
				<form action="FeedbackInsertServlet" method="post">
					<div class="gujju-container">
						<div class="gujju-row">
							<div class="gujju-col m12" style="height: 30%">

								<textarea class=" form-control" name="txtfeedback"></textarea>
								<br />
								<div>
									<input type="submit" value="Send Feedback"
										class=" gujju-theme gujju-btn" /> <br /> <br />
								</div>
							</div>
						</div>
					</div>
				</form>
				<footer class="gujju-animate-opacity gujju-container gujju-theme">
				<p>gujjubus2015@gmail.com</p>
			</div>
		</div>
	</div>
	<%@include file="UserFooter.jsp" %>
	<script>
		$(document).ready(function() {
			$("#contactus").removeClass("gujju-blue gujju-card-24");
			$("#contactus").addClass("gujju-theme-d2 gujju-card-24");

		});
	</script>
</body>
</html>
