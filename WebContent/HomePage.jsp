<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>ADMIN</title>

<script src="Gujjubus-javaScript/Jquery/jquery.min.js"
	type="text/javascript"></script>
<style>
.img {
	float: left
}
</style>
<link rel="icon" href="Gujjubus-photos/logo.ico" /></head>

<body class="col-*-*">
	<%@include file="AdminHeader.jsp"%>
	<!-- .............................................................................................End of Header.........................................-->
	<!-- .............................................................................................Side bar.... start.....................................-->
	<div class="col-md-3 gujju-quarter gujju-card-8 "  >
		<div class="container">
			<div class="row">
				<div class="col-*-10">
					<a href="Admindashboard.jsp" style="text-decoration: none;"><span
						id="desh" class="col-md-3 gujju-quarter"> <i class="fa fa-tachometer" style="font-size: 20px;"></i>&emsp;&emsp;Dashboard</span>
					</a> <br /> <br />
					<!-- .................................................................User....................... -->
					<span class="col-md-3 gujju-quarter gujju-quarter " id="User">
					 <i class="fa-user fa" style="font-size: 20px;"></i>&emsp;&emsp;&emsp;&nbsp;&emsp;&emsp;	User </span> <br /> <br />
					<div id="treeUser">
						<a href="Registration.jsp" style="text-decoration: none;"> <span
							class="col-md-2" style="margin-left: 20px;" id="addUser">
								<i class="fa fa-user-plus"  >&emsp; &emsp; Add</i>
						</span> </a><br /> <br /> <a href="UserListServlet"
							style="text-decoration: none;"> <span class=" col-md-2"
							style="margin-left: 20px;" id="listUser"> <i
								class="fa fa-reorder">&emsp; &emsp; List</i> </span> </a> <br /> <br />
					</div>
					<!-- ......................................................Admin.......................................................................... ---->
					<span class="col-md-3 gujju-quarter" id="registration"><i class="fa fa-user-secret" style="font-size: 20px;"></i>&emsp;&emsp;&emsp;&nbsp;&emsp;&emsp; Admin</span> <br /> <br />
					<div id="treeRegistration">
						<a href="AdminInsert.jsp" style="text-decoration: none;"> <span
							class="col-md-2" style="margin-left: 20px;" id="addAdmin">
								<i class="fa fa-user-secret">&emsp; &emsp; Add</i>
						</span> </a><br /> <br /> <a href="AdminListServlet"
							style="text-decoration: none;"> <span id="AdminList"
							class="col-md-2" style="margin-left: 20px;"> <i
								class="fa fa-reorder">&emsp; &emsp; List</i>
						</span> </a><br /> <br />
					</div>
					<!--.................................................................................. ......................Bus toggle....................-->
					<span class="col-md-3 gujju-quarter" id="bus"><i class="fa-bus fa" style="font-size: 20px;"></i>&emsp;&emsp;&emsp;&nbsp;&emsp;&emsp;&emsp;&emsp;Bus</span>
					<br /> <br />
					<div id="treeBus">
						<!-- inner......................Bus toggle....................-->

						<span class="col-md-2" id="Businner"><i class="fa-bus fa">&emsp;&emsp;
								Bus</i> </span> <br /> <br />
						<div id="treeBusinner">
							<a href="BusInsert.jsp" style="text-decoration: none;"> <span
								class="col-md-2" style="margin-left: 20px;" id="addBus">
									Add</span> </a><br /> <br /> <a href="BusListServlet"
								style="text-decoration: none;"> <span class=" col-md-2"
								style="margin-left: 20px;" id="listBus"> List Bus </span> </a><br />
							<br />
						</div>
						<!--iner .................................................................Bus Detail....................... -->
						<span class="col-md-2" id="Busdetail"> <i
							class="fa fa-cogs"> &nbsp; Bus Detail</i> </span> <br /> <br />
						<div id="treeBusdetail">
							<a href="BusDetailInsert.jsp" style="text-decoration: none;">
								<span class=" col-md-2" style="margin-left: 20px;"
								id="addBusdetail"> Add</span> </a><br /> <br /> <a
								href="BusDetailListServlet" style="text-decoration: none;">
								<span class=" col-md-2" style="margin-left: 20px;"
								id="listBusdetail"> List </span> </a> <br /> <br />
						</div>

						<!-- inner.................................................................Bus Type....................... -->
						<span class="col-md-2" id="Bustype"> <i
							class="fa fa-binoculars"> Bus Type</i> </span> <br /> <br />
						<div id="treeBustype">
							<a href="BusTypeInsert.jsp" style="text-decoration: none;"> <span
								class=" col-md-2" style="margin-left: 20px;" id="addBustype">
									Add</span> </a><br /> <br /> <a href="BusTypeListServlet"
								style="text-decoration: none;"> <span class=" col-md-2"
								style="margin-left: 20px;" id="listBustype"> List </span> </a> <br />
							<br />
						</div>

						<!-- inner.................................................................Bus Category....................... -->
						<span class="col-md-2" id="Buscategory"> <i
							class="fa fa-sitemap">Bus</i> Category </span> <br /> <br />
						<div id="treeBuscategory">
							<a href="BusCategoryInsert.jsp" style="text-decoration: none;">
								<span class=" col-md-2" style="margin-left: 20px;"
								id="addBusCategory"> Add</span> </a><br /> <br /> <a
								href="BusCategoryListServlet" style="text-decoration: none;">
								<span class=" col-md-2" style="margin-left: 20px;"
								id="listBusCategory"> List </span> </a> <br /> <br />
						</div>
					</div>
					<!-- .................................................................Reservation....................... -->
					<span class="col-md-3 gujju-quarter" id="reservation"><i class="fa-ticket fa" style="font-size: 20px;"></i>&emsp;&emsp;&emsp;Reservation</span>
					<br /> <br />
					<div id="treeReservation">
						<a href="AdminSearch.jsp" style="text-decoration: none;"> <span
							class=" col-md-2 " style="margin-left: 20px;" id="addReservation">
								<i class="fa fa-ticket">&emsp;&emsp; Add</i> </span> </a><br /> <br /> <a
							href="ReservationListServlet" style="text-decoration: none;">
							<span class=" col-md-2" id="listReservation"
							style="margin-left: 20px;"><i class="fa fa-navicon">List
							</i> </span> </a><br /> <br />
					</div>
					<!-- .................................................................City....................... -->
					<span class="col-md-3 gujju-quarter" id="city"><i class="fa fa-building-o" style="font-size: 20px;"></i>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;City</span>
					<br /> <br />
					<div id="treeCity">
						<a href="CityInsert.jsp" style="text-decoration: none;"> <span
							class=" col-md-2" style="margin-left: 20px;" id="addCity"><i
								class="fa fa-building-o">&emsp;&emsp; Add </i> </span> </a><br /> <br />
						<a href="CityListServlet" style="text-decoration: none;"> <span
							class=" col-md-2" style="margin-left: 20px;" id="listCity">
								<i class="fa fa-navicon">&emsp;&emsp; List </i> </span> </a><br /> <br />
					</div>

					<!-- .................................................................Organization....................... -->
					<span class="col-md-3 gujju-quarter" id="org"><i class="fa-group fa" style="font-size: 20px;"></i>&emsp;&emsp;&emsp;Organization</span>
					<br /> <br />
					<div id="treeOrg">
						<a href="OrganizatioInsert.jsp" style="text-decoration: none;">
							<span class=" col-md-2" style="margin-left: 20px;"
							id="addOrganization"> <i class="fa-group fa">&emsp;&emsp;
									Add</i> </span> </a><br /> <br /> <a href="OrganizationListServlet"
							style="text-decoration: none;"> <span class=" col-md-2"
							id="listOrganization" style="margin-left: 20px;"> <i
								class="fa fa-navicon">&emsp;&emsp; List </i> </span> </a><br /> <br />
					</div>

					<!-- .................................................................Pass ....................... -->
					<span class="col-md-3 gujju-quarter" id="pass"><i class="fa fa-newspaper-o" style="font-size: 20px;"></i>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Pass</span>
					<br /> <br />
					<div id="treePass">
						<!-- ..................................................inner pass....................................-->
						<span class="col-md-2" id="Passinner"> <i
							class="fa fa-newspaper-o">&emsp;&emsp; Pass</i>
						</span> <br /> <br />
						<div id="treePassinner">

							<a href="PassInsert.jsp" style="text-decoration: none;"> <span
								class=" col-md-2" style="margin-left: 20px;" id="addPass"><i
									class="fa fa-newspaper-o">&emsp;&emsp; Add </i> </span> </a><br /> <br />
							<a href="PassListServlet" style="text-decoration: none;"> <span
								class=" col-md-2" style="margin-left: 20px;" id="listPass"><i
									class="fa fa-navicon">&emsp;&emsp; List </i>
							</span> </a><br /> <br />
						</div>
						<!-- ..................................................inner pass type....................................-->
						<span class="col-md-2" id="Passtype"> <i
							class="fa fa-gears">Pass Type</i>
						</span> <br /> <br />
						<div id="treePasstype">
							<a href="PassTypeInsert.jsp" style="text-decoration: none;">
								<span class=" col-md-2" style="margin-left: 20px;"
								id="addPasstype"><i class="fa fa-filter">&emsp;&emsp;
										Add</i> </span> </a><br /> <br /> <a href="PassTypeListServlet"
								style="text-decoration: none;"> <span class=" col-md-2"
								id="listPasstype" style="margin-left: 20px;"><i
									class="fa fa-navicon">&emsp;&emsp; List </i>
							</span> </a><br /> <br />
						</div>
					</div>


					<!-- .................................................................Seat....................... -->
					<span class="col-md-3 gujju-quarter" id="seat"><img
						class="img" src="Gujjubus-photos/Seat.gif" height="20" width="20" style="margin-left: 45px;" />Seat
						Type</span> <br /> <br />
					<div id="treeSeat">
						<a href="SeatTypeInsert.jsp" style="text-decoration: none;"> <span
							class=" col-md-2" style="margin-left: 20px;" id="addSeat">
								<i class="fa fa-sitemap">&emsp;&emsp; Add</i> </span> </a><br /> <br /> <a
							href="SeatTypeListServlet" style="text-decoration: none;"> <span
							class=" col-md-2" style="margin-left: 20px;" id="listSeat">
								<i class="fa fa-navicon">&emsp;&emsp; List </i>
						</span> </a><br /> <br />
					</div>
					<!-- .................................................................Schedule....................... -->
					<span class="col-md-3 gujju-quarter" id="schedule"><i class="fa fa-bars" style="font-size: 20px;"></i> &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Schedule</span> <br /> <br />
					<div id="treeSchedule">
						<a href="ScheduleDetailInsert.jsp" style="text-decoration: none;">
							<span class=" col-md-2" style="margin-left: 20px;"
							id="addSchedule"> <i class="fa fa-tachometer">&emsp;&emsp;
									Add </i> </span> </a><br /> <br /> <a href="ScheduleDetailListServlet"
							style="text-decoration: none;"> <span class=" col-md-2"
							id="listSchedule" style="margin-left: 20px;"> <i
								class="fa fa-navicon">&emsp;&emsp; List </i> </span> </a><br /> <br />
					</div>
					<!-- .................................................................Route....................... -->
					<span class="col-md-3 gujju-quarter" id="route"> <i class="fa-road fa"  style=" font-size: 20px;"></i>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Route</span>
					<br /> <br />
					<div id="treeRoute">
						<a href="RouteInsert.jsp" style="text-decoration: none;"> <span
							class=" col-md-2" style="margin-left: 20px;" id="addRoute">
								<i class="fa fa-road">&emsp;&emsp; Add </i> </span> </a><br /> <br /> <a
							href="RouteListServlet" style="text-decoration: none;"> <span
							class=" col-md-2" style="margin-left: 20px;" id="listRoute">
								<i class="fa fa-navicon">&emsp;&emsp; List </i> </span> </a><br /> <br />
					</div>
					<!-- .................................................................Station....................... -->
					<span class="col-md-3 gujju-quarter" id="station"><img
						class="img" src="Gujjubus-photos/station.jpg" height="20"
						width="20" style="margin-left: 50px;" />Station</span> <br /> <br />
					<div id="treeStation">
						<a href="StationInsert.jsp" style="text-decoration: none;"> <span
							id="addStation" class=" col-md-2" style="margin-left: 20px;">
								<i class="fa fa-street-view">&emsp;&emsp; Add </i> </span> </a><br /> <br />
						<a href="StationListServlet" style="text-decoration: none;"> <span
							class=" col-md-2" id="listStation" style="margin-left: 20px;">
								<i class="fa fa-navicon">&emsp;&emsp; List </i> </span> </a><br /> <br />
					</div>
					<!-- .................................................................Feedback....................... -->
				<a href="FeedbackListServlet">	<span class="col-md-3 gujju-quarter gujju-quarter " id="FeedBack">
					<i class="fa-user fa" style="font-size: 20px;"></i>&emsp;&emsp;&emsp;&nbsp;&emsp;&emsp;Feedback</span> <br /> <br />
					 </a>
					<!--............    .            ................... ................  end ............................   -->
				</div>
			</div>
		</div>
	</div>
</body>
</html>
