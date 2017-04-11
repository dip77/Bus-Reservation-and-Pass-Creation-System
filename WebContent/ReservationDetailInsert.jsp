
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.digimation.gujjubus.dao.ReservationDetailDAO"%>
<%@page import="com.digimation.gujjubus.bean.ReservationDetailBean"%>
<%@page import="com.digimation.gujjubus.bean.ReservationBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.digimation.gujjubus.dao.ReservationDAO"%>
<html>
<head runat="server">
<title>Reservation</title>
<script src="Gujjubus-javaScript/Jquery/jquery.min.js"
	type="text/javascript"></script>
<style type="text/css">
#holder {
	height: 360px;
	width: 790px;
	background-color: #F5F5F5;
	border: 1px solid #A4A4A4;
	margin-left: 20px;
	border-radious: 5em;
}

#place {
	position: relative;
	margin: 7px;
}

#place a {
	font-size: x-small;
}

#place li {
	list-style: none outside none;
	position: absolute;
}

#place li:hover {
	background-color: #FFFF00;
}

#place .seat {
	background: url(Gujjubus-photos/available.gif) no-repeat scroll 0 0
		transparent;
	height: 63px;
	width: 63px;
	display: block;
}

#place .selectedSeat {
	background: url(Gujjubus-photos/Reservedseat.gif) no-repeat scroll 0 0
		transparent;
}

#place .selectingSeat {
	background-image: url(Gujjubus-photos/Selected.gif);
}

#place .row-3,#place .row-4 {
	margin-top: 10px;
}

#seatDescription {
	padding: 0px;
}

#seatDescription li {
	verticle-align: middle;
	list-style: none outside none;
	padding-left: 35px;
	height: 45px;
	float: left;
}
</style>

<link rel="icon" href="Gujjubus-photos/logo.ico" /></head>
<body>
	<div class="col-*-*">
		<%@include file="HomePage.jsp"%>
		
		<div class="gujju-row">
		<div class="gujju-col m4">
		<form name="reservation" method="post">
			<script src="gujjubus-javascript/jquery.min.js"></script>
			<div class="btn text-primary">
				<font size="+3">Select Seat:</font>
			</div>
			<div id="holder">
				<!-- Seat outer Div-->
				<ul id="place">
					<!-- Seat layout -->
				</ul>
			</div>

			<div class="container">
				<div class="row">
					<div class="col-md-3">
						<img src="Gujjubus-photos/Reservedseat.gif"><b>Booked
							Seat</b>
					</div>
					<div class="col-md-3">
						<img src="Gujjubus-photos/available.gif"><b>Available
							Seat</b>
					</div>
					<div class="col-md-3">
						<img src="Gujjubus-photos/Selected.gif"><b>Selected Seat</b>
					</div>
				</div>
			</div>

			<div style="margin-left: 850px;">
				<input type="button" id="btnShowNew" class="gujju-btn gujju-green"
					value="Submit" />

			</div>
			<script type="text/javascript">
			var str = [];
			var str1 = [];
			$(function() {
				var settings = {
					rows : 5,
					cols : 10,
					rowCssPrefix : 'row-',
					colCssPrefix : 'col-',
					seatWidth : 67,
					seatHeight : 67,
					seatCss : 'seat',
					selectedSeatCss : 'selectedSeat',
					selectingSeatCss : 'selectingSeat'
				};
				var init = function(reservedSeat) {
					var str = [], seatNo, className;
					for (i = 0; i < settings.rows; i++) {
						for (j = 0; j < settings.cols + 1; j++) {
							seatNo = (i + j * settings.rows + 1);
							className = settings.seatCss + ' '
									+ settings.rowCssPrefix + i.toString()
									+ ' ' + settings.colCssPrefix
									+ j.toString();
							if ($.isArray(reservedSeat)
									&& $.inArray(seatNo, reservedSeat) != -1) {
								className += ' ' + settings.selectedSeatCss;
							}
							str.push('<li class="' + className + '"'
									+ 'style="top:'
									+ (i * settings.seatHeight).toString()
									+ 'px;left:'
									+ (j * settings.seatWidth).toString()
									+ 'px">' + '<a title="' + seatNo + '">'
									+ seatNo + '</a>' + '</li>');

						}
					}
					$('#place').html(str.join(''));
				};
				var bookedSeats=[];
				//case I: Show from starting
				//init();

				//Case II: If already booked
				
				<%
				session=request.getSession();
				ReservationBean reservationBean=(ReservationBean)session.getAttribute("reservationBean");  
				ArrayList <ReservationDetailBean> listOfReservationdetailBean= new ReservationDetailDAO().getReservationSeats(reservationBean);
				%>
			
				<%
				for(int i=0;i<listOfReservationdetailBean.size();i++)
				                    {	
				                   		%>
				                   	
				                   		bookedSeats.push(<%=listOfReservationdetailBean.get(i).getSeatNum()%>);
				                    <%	
				                    }
				                    %>
				init(bookedSeats);
				$('.' + settings.seatCss).click(function() {
					if ($(this).hasClass(settings.selectedSeatCss)) {
						alert('This seat is already reserved');
					} else {
						$(this).toggleClass(settings.selectingSeatCss);
					}
				});
				$('#btnShow').click(
						function() {
							$.each($('#place li.' + settings.selectedSeatCss
									+ ' a, #place li.'
									+ settings.selectingSeatCss + ' a'),
									function(index, value) {
										str.push($(this).attr('title'));
									});

							str1 = str.join(',');
							
						});
				$('#btnShowNew').click(
						function() {
							var str = [], item;
							$.each($('#place li.' + settings.selectingSeatCss
									+ ' a'), function(index, value) {
								item = $(this).attr('title');
								str.push(item);
							});
							alert(str.join(','));
							document.reservation.action = "ReseravationDetailInsertServlet?id=" + str;
							document.reservation.submit();
						});
			});
		</script>
		</form>
	</div>
</div></div></div>
</body>
</html>
