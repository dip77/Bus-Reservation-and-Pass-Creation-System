<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="Header.jsp"%>
<form action="ForgotPasswordServlet" method="post">

<div style="margin-top: 100px; margin-left:300px; ">
<font color="red"  style="text-transform: capitalize; font-size-adjust: inherit; font-size: 30px;">${msglogin}</font>
							<label class="col-lg-2">Email</label>
							<div class="col-md-3">
					<input type="email" name="txtemail"
						placeholder="Example@gujjubus.com" value="${param.txtemail}"
				class="form-control" />
								<font color="red"  style="text-transform: capitalize;">	${username}</font>
							</div>
						</div>
						<br />
						<br />
						
						<div class="gujju-col m7">
							<input type="submit" name="txtemail" value="Send Mail"
								class=" gujju-blockquote gujju-theme gujju-btn   " style="margin-left: 490px;" />
							</div>
						
		</form>				
</body>
</html>