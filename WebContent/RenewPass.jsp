<%@page import="com.digimation.gujjubus.dao.PassTypeDAO"%>
<%@page import="com.digimation.gujjubus.dao.PassDAO"%>
<%@page import="com.digimation.gujjubus.bean.PassTypeBean"%>
<%@page import="com.digimation.gujjubus.dao.OrganizationDAO"%><%@page
	import="com.digimation.gujjubus.bean.OrganizationBean"%>
<%@page import="com.digimation.gujjubus.bean.UserBean"%>
<%@page import="com.digimation.gujjubus.dao.UserDAO"%>
<%@page import="com.digimation.gujjubus.dao.PassTypeDAO"%>
<%@page import="com.digimation.gujjubus.dao.PassDAO"%>
<%@page import="com.digimation.gujjubus.bean.PassTypeBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.digimation.gujjubus.bean.StationBean"%>
<%@page import="com.digimation.gujjubus.dao.StationDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pass Insert</title>
<link rel="icon" href="Gujjubus-photos/logo.ico" /></head>
<body class="col-*-*">
 
<%@include file="UserHeader.jsp" %>
	<div class="col-lg-8">
		<br>
		<%!ArrayList<StationBean> routeBeansList;
	ArrayList<PassTypeBean> passTypeBeansList;%>

		<form action="PassRenewInsertServlet" method="post" >

			<div class="container ">
			 		<%
				 UserBean userBean=(UserBean)session.getAttribute("userBean");
			 		if(!new PassDAO().isExists(userBean.getUserId()))
			 		{
			 			response.sendRedirect("ErrorPass.jsp");	
			 		}
					String one = "", three = "", gen = request.getParameter("rdoval");
					if (gen != null) {	
						if (gen.equals("1"))
							one = "checked";
						else
							three = "checked";
					}
				%>
					<div class="row">
						<div class="col-lg-10">
							<label class="col-sm-4"><font size="+1"> Pass
									Validity </font> </label>
							<div class="col-lg-6">
								<input type="radio" name="rdoval" value="1"  <%=one%>>1
								Months <input type="radio" name="rdoval" value="3" <%=three%>>3
								Months ${msgval}
							</div>
						</div>
					</div>
					<br />

					<%
					gen = request.getParameter("rdostart");
					if (gen != null) {
						if (gen.equals("1"))
							one = "checked";
						else
							three = "checked";
					}
				%>
					<div class="row">
						<div class="col-lg-10">
							<label class="col-sm-4"><font size="+1"> Pass
									Start Day </font> </label>
							<div class="col-lg-6">
								<input type="radio" name="rdostart" value="1"  <%=one%>>Today
								<input type="radio" name="rdostart" value="2" <%=three%>>Tommorow
								<font color="red" ><b>${msgval}</b></font>
							</div>
						</div>
					</div>
					<br>
					<%
					gen = request.getParameter("seltermvalidity");
					String arry[] = new String[4];
					if (gen != null) {
						switch (Integer.parseInt(gen)) {

						case 6:
							arry[0] = "selected";
							break;

						case 12:
							arry[1] = "selected";
							break;
						}
					}
				%>
				
					<div class="row">
				
<div  class="gujju-col m6 ">
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
	<div style="margin-top: 500px;">
 <%@ include file="UserFooter.jsp" %></div>
</body>
</html>