<%@page import="com.sun.org.apache.regexp.internal.recompile"%>
<%@page import="com.digimation.gujjubus.dao.RouteDAO"%>
<%@page import="com.digimation.gujjubus.bean.RouteBean"%>
<%@page import="com.digimation.gujjubus.dao.BusDetailDAO"%>
<%@page import="com.digimation.gujjubus.bean.BusDetailBean"%>
<%@page import="com.digimation.gujjubus.dao.BusDAO"%>
<%@page import="com.digimation.gujjubus.bean.BusBean"%>
<%@page import="com.digimation.gujjubus.dao.StationDAO"%>
<%@page import="com.digimation.gujjubus.bean.StationBean"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//gujjuC//DTD XHTML 1.0 Transitional//EN" "http://www.gujju.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>GujjuBus.com</title>


 <style>
.carousel-inner>.item>img,.carousel-inner>.item>a>img {
	width: 300%;
	height: 600%;
	margin: auto;
}
</style>

<link rel="icon" href="Gujjubus-photos/logo.ico" /></head>
<body >
<div>
	<%@ include file="Header.jsp"%>
	<!-- start source and destination -->
	<div class="gujju-third">
<div style="font-size: 20px;font-stretch: ultra-condensed; " class="col-md-10 text-info" ><center>Search Gujju Bus <span class="fa-search fa"></span></center></div>
		<form action="GuestScheduleListServlet" method="post" style="margin-top: 70px;">
			<div class="gujju-container">
				<div class="gujju-row" >
					<div class="col-lg-10">
						<label class="col-md-4" style="font-size: 18px">From :</label>
						<div class="col-lg-8">
							<%!ArrayList<StationBean> stationBeansList;%>
							<input list="Source"  name="Source" placeholder="Source" style="text-transform: capitalize;" maxlength="15" class="form-control"
								autocomplete="off" value="${param.Destination}" />

							<datalist id="Source"> <%
 	stationBeansList = new StationDAO().getStationList();
 	for (int i = 0; i < stationBeansList.size(); i++) {

 		String tmp = "unselected";
 		String type = request.getParameter("seldestination");
 		if (type == null)
 			tmp = "unselected";
 		else if (stationBeansList.get(i).getStationId() == Integer
 				.parseInt(type))
 			tmp = "selected";
 %>


							<option value="<%=stationBeansList.get(i).getStationName()%>"></option>
							<!-- all option value  name like Gandhinagar--> <%
						
 	}
 %> </datalist>
							<div class="gujju-text-red text-uppercase">${msgsource}</div>

						</div>
					</div>
				</div>
				<br /> 
				<div class="gujju-row ">
					<div class="col-lg-10">
						<label class="col-md-4" style="font-size: 18px;">&emsp;
							To :</label>
						<div class="col-lg-8">
							<input list="Destination" name="Destination" placeholder="Destination" maxlength="13" class="form-control"
							style="text-transform:  capitalize;"	autocomplete="off" value="${param.Destination}" />
							<datalist id="Destination"> <%
 	stationBeansList = new StationDAO().getStationList();

 	for (int i = 0; i < stationBeansList.size(); i++) {

 		String tmp = "unselected";
 		String type = request.getParameter("seldestination");
 		if (type == null)
 			tmp = "unselected";
 		else if (stationBeansList.get(i).getStationId() == Integer
 				.parseInt(type))
 			tmp = "selected";
 %>
							<option value="<%=stationBeansList.get(i).getStationName()%>"></option>
							<!-- all option value  name like Gandhinagar--> <%
 	}
 %> </datalist>
							<div class="gujju-text-red text-uppercase">
								${msgdestination}</div>
						</div>
					</div>
				</div>
				<br /> <br />
				<div class="gujju-row ">
					<div class="col-lg-9 ">
						<button type="submit"
							class="gujju-blockquote btn-block  gujju-btn gujju-theme"
							value="Search Bus" ><i class="fa-search fa">&emsp; Search </i></button> <br /> <br />
					</div>
				</div>
			</div>
		</form>
		<div class="gujju-col m9 gujju-card-8"
			style="border-color: blue; margin-left: 15px; border: 2px solid skyblue; border-radius: 10px 10px 10px;">
			<div class="gujju-btn  btn-block gujju-theme-l4"
				style="outline-color: blue;">Special Services</div>
			<ul
				style="text-decoration: none; outline-color: blue; list-style-type: circle; list-style-position: inside;">
				<li>Book Online Ticket</li>
				<li>Get Pass</li>
				<li>Show Schedule.</li>
				<li>Concession on Student Pass</li>
			</ul>
		</div>
	</div>
	<div class="gujju-container">
		<div class="gujju-row">
			<br />
			<div class="gujju-col m8 gujju-card-16" style="margin-top: -30px;">
				<div id="myCarousel" class="carousel slide" data-ride="carousel">
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
						<li data-target="#myCarousel" data-slide-to="1"></li>
						<li data-target="#myCarousel" data-slide-to="2"></li>
						<li data-target="#myCarousel" data-slide-to="3"></li>
						<li data-target="#myCarousel" data-slide-to="4"></li>
						<li data-target="#myCarousel" data-slide-to="5"></li>
						<li data-target="#myCarousel" data-slide-to="6"></li>
						<li data-target="#myCarousel" data-slide-to="7"></li>
						<li data-target="#myCarousel" data-slide-to="8"></li>
						<li data-target="#myCarousel" data-slide-to="9"></li>
					</ol>
					<!-- Wrapper for slides -->
					<div class=" carousel-inner" role="listbox">
						<div class="item active ">
							<img
								src="photo/slid (2).jpg"
								alt="Chania" />
						</div>
						<div class="item">
							<img src="photo/slid (3).jpg" alt="Chania" />
						</div>
						<div class="item">
							<img src="photo/s415hd.jpg" alt="Flower" />
						</div>
						<div class="item">
							<img src="photo/big_thumb_825e932ab913fe1410fcf43e2b780080.jpg"
								alt="Flower">
						</div>
						<div class="item">
							<img src="photo/volvo-bus-main_678x352_81436865807.jpg"
								alt="Flower">
						</div>
						<div class="item">
							<img
								src="photo/sightseeing-busTEMSA-HD-C-12---1_big--15062615252098111700.jpg"
								alt="Flower">
						</div>
						<div class="item">
							<img
								src="photo/sightseeing-busTEMSA-HD-C-12---3_big--15062615252098111700.jpg"
								alt="Flower">
						</div>
						<div class="item">
							<img src="photo/slid (1).jpg" alt="Flower">
						</div>
						<div class="item">
							<img src="photo/download.jpg" alt="Flower">
						</div>
						<div class="item">
							<img src="photo/images.jpg" alt="Flower">
						</div>
					</div>
					<!-- Left and right controls -->
					<a class="left carousel-control" href="#myCarousel" role="button"
						data-slide="prev"> <span
						class="fa-hand-o-left fa glyphicon glyphicon-chevron-left"
						aria-hidden="true"></span> <span class="sr-only">Previous</span> </a>
					<a class="right carousel-control" href="#myCarousel" role="button"
						data-slide="next"> <span
						class="fa-hand-o-right fa glyphicon glyphicon-chevron-right"
						aria-hidden="true"></span> <span class="sr-only">Next</span> </a>
				</div>
			</div>
		</div>
	</div>
	<%@include
		file="Footer.jsp"%> 
	 
<script>
			$(document).ready(function() {
				$("#home").removeClass("gujju-blue gujju-card-24");
				$("#home").addClass("gujju-theme-d2 gujju-card-24");
				 
			});
			</script>
	 
</div>
</body>
</html>
