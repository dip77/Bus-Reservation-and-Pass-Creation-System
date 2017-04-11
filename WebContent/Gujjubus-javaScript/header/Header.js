// JavaScript Document

$(document).ready(function() {

 	$("span").hover(function(){
		$(this).addClass("gujju-card-8 gujju-blue");
		
		
	});
$("span").mouseleave(function(){
		$(this).removeClass("gujju-card-8 gujju-blue");
	});
 
$("input").addClass("input-sm");
$("select").addClass("input-sm");

	$("#treePassinner").hide();
	$("#treePasstype").hide();

	$("#treeBusdetail").hide();
	$("#treeBuscategory").hide();
	$("#treeBustype").hide();
	$("#treeBusinner").hide();
	$("#treeUser").hide();
	$("#treePass").hide();
	$("#treeRegistration").hide();
	$("#treeBus").hide();
	$("#treeReservation").hide();
	$("#treeCity").hide();
	$("#treeOrg").hide();
	$("#treeSeat").hide();
	$("#treeStation").hide();
	$("#treeSchedule").hide();
	$("#treeRoute").hide();

	$("#User").click(function() {
		$(this).addClass("effect");
		$("#Busdetail").removeClass(" effect");
		$("#Buscategory").removeClass(" effect");
		$("#Bustype").removeClass(" effect");
		$("#bus").removeClass(" effect");
		$("#pass").removeClass(" effect");
		$("#city").removeClass(" effect");
		$("#org").removeClass(" effect");
		$("#seat").removeClass(" effect");
		$("#station").removeClass(" effect");
		$("#schedule").removeClass(" effect");
		$("#route").removeClass(" effect");
		$("#reservation").removeClass(" effect");
		$("#registration").removeClass(" effect");

		$("#treeRegistration").slideUp(300);
		$("#treeBus").slideUp(300);
		$("#treePass").slideUp(300);
		$("#treeCity").slideUp(300);
		$("#treeOrg").slideUp(300);
		$("#treeSeat").slideUp(300);
		$("#treeStation").slideUp(300);
		$("#treeSchedule").slideUp(300);
		$("#treeRoute").slideUp(300);
		$("#treeReservation").slideUp(300);
		$("#treeBusdetail").slideUp(300);
		$("#treeBuscategory").slideUp(300);
		$("#treeBustype").slideUp(300);

		$("#treeUser").slideToggle(300);

	});

	$("#registration").click(function() {
		$(this).addClass(" effect");
		$("#Busdetail").removeClass(" effect");
		$("#Buscategory").removeClass(" effect");
		$("#Bustype").removeClass(" effect");
		$("#bus").removeClass(" effect");
		$("#pass").removeClass(" effect");
		$("#city").removeClass(" effect");
		$("#org").removeClass(" effect");
		$("#seat").removeClass(" effect");
		$("#station").removeClass(" effect");
		$("#schedule").removeClass(" effect");
		$("#route").removeClass(" effect");
		$("#User").removeClass(" effect");
		$("#reservation").removeClass(" effect");

		$("#treeBusdetail").slideUp(300);
		$("#treeBuscategory").slideUp(300);
		$("#treeBustype").slideUp(300);
		$("#treeBus").slideUp(300);
		$("#treePass").slideUp(300);
		$("#treeUser").slideUp(300);
		$("#treeCity").slideUp(300);
		$("#treeOrg").slideUp(300);
		$("#treeSeat").slideUp(300);
		$("#treeStation").slideUp(300);
		$("#treeSchedule").slideUp(300);
		$("#treeRoute").slideUp(300);
		$("#treeReservation").slideUp(300);
		$("#treeRegistration").slideToggle(300);

	});

	$("#bus").click(function() {
		$("#User").removeClass(" effect");
		$("#pass").removeClass(" effect");
		$("#city").removeClass(" effect");
		$("#org").removeClass(" effect");
		$("#seat").removeClass(" effect");
		$("#station").removeClass(" effect");
		$("#schedule").removeClass(" effect");
		$("#route").removeClass(" effect");
		$("#registration").removeClass(" effect");
		$("#reservation").removeClass(" effect");

		$("#treeBusdetail").slideUp(300);
		$("#treeBuscategory").slideUp(300);
		$("#treeBustype").slideUp(300);
		$("#treeBusinner").slideUp(300);

		$("#treeCity").slideUp(300);
		$("#treePass").slideUp(300);
		$("#treeOrg").slideUp(300);
		$("#treeSeat").slideUp(300);
		$("#treeStation").slideUp(300);
		$("#treeSchedule").slideUp(300);
		$("#treeRoute").slideUp(300);
		$("#treeUser").slideUp(300);
		$("#treeRegistration").slideUp(300);
		$("#treeReservation").slideUp(300);

		$("#treeBus").slideToggle(300);
		$(this).addClass(" effect");
	});

	// inner bus div

	$("#Bustype").click(function() {
		$(this).addClass(" effect");
		$("#Busdetail").removeClass(" effect");
		$("#Buscategory").removeClass(" effect");
		$("#Businner").removeClass(" effect");

		$("#treeBusdetail").slideUp(300);
		$("#treeBuscategory").slideUp(300);
		$("#treeBusinner").slideUp(300);
		$("#treeBustype").slideToggle(300);
	});

	$("#Busdetail").click(function() {
		$(this).addClass(" effect");

		$("#Bustype").removeClass(" effect");
		$("#Buscategory").removeClass(" effect");
		$("#Businner").removeClass(" effect");

		$("#treeBustype").slideUp(300);
		$("#treeBuscategory").slideUp(300);
		$("#treeBusinner").slideUp(300);

		$("#treeBusdetail").slideToggle(300);
	});

	$("#Businner").click(function() {
		$(this).addClass(" effect");
		$("#Bustype").removeClass(" effect");
		$("#Busdetail").removeClass(" effect");
		$("#Buscategory").removeClass(" effect");
		$("#treeBustype").slideUp(300);
		$("#treeBusdetail").slideUp(300);
		$("#treeBusinner").slideToggle(300);
	});

	$("#Buscategory").click(function() {
		$(this).addClass(" effect");

		$("#Bustype").removeClass(" effect");
		$("#Busdetail").removeClass(" effect");
		$("#Businner").removeClass(" effect");

		$("#treeBustype").slideUp(300);
		$("#treeBusdetail").slideUp(300);
		$("#treeBusinner").slideUp(300);
		$("#treeBuscategory").slideToggle(300);
	});

	// inner bus end
	$("#reservation").click(function() {
		$("#Busdetail").removeClass(" effect");
		$("#Buscategory").removeClass(" effect");
		$("#Bustype").removeClass(" effect");

		$("#User").removeClass(" effect");
		$("#bus").removeClass(" effect");
		$("#pass").removeClass(" effect");
		$("#city").removeClass(" effect");
		$("#org").removeClass(" effect");
		$("#seat").removeClass(" effect");
		$("#station").removeClass(" effect");
		$("#schedule").removeClass(" effect");
		$("#route").removeClass(" effect");
		$("#registration").removeClass(" effect");
		$("#treeBusdetail").slideUp(300);
		$("#treeBuscategory").slideUp(300);
		$("#treeBustype").slideUp(300);
		$("#treeBus").slideUp(300);
		$("#treePass").slideUp(300);
		$("#treeCity").slideUp(300);
		$("#treeOrg").slideUp(300);
		$("#treeUser").slideUp(300);
		$("#treeSeat").slideUp(300);
		$("#treeStation").slideUp(300);
		$("#treeSchedule").slideUp(300);
		$("#treeRoute").slideUp(300);
		$("#treeRegistration").slideUp(300);

		$("#treeReservation").slideToggle(300);
		$(this).addClass(" effect");
	});

	$("#city").click(function() {
		$("#Busdetail").removeClass(" effect");
		$("#Buscategory").removeClass(" effect");
		$("#Bustype").removeClass(" effect");

		$("#User").removeClass(" effect");
		$("#bus").removeClass(" effect");
		$("#pass").removeClass(" effect");
		$("#org").removeClass(" effect");
		$("#seat").removeClass(" effect");
		$("#station").removeClass(" effect");
		$("#schedule").removeClass(" effect");
		$("#route").removeClass(" effect");
		$("#registration").removeClass(" effect");
		$("#reservation").removeClass(" effect");

		$("#treeBusdetail").slideUp(300);
		$("#treeBuscategory").slideUp(300);
		$("#treeBustype").slideUp(300);
		$("#treeBus").slideUp(300);
		$("#treePass").slideUp(300);
		$("#treeOrg").slideUp(300);
		$("#treeSeat").slideUp(300);
		$("#treeUser").slideUp(300);
		$("#treeStation").slideUp(300);
		$("#treeSchedule").slideUp(300);
		$("#treeRoute").slideUp(300);
		$("#treeRegistration").slideUp(300);
		$("#treeReservation").slideUp(300);

		$("#treeCity").slideToggle(300);
		$(this).addClass(" effect");
	});

	$("#org").click(function() {
		$("#Busdetail").removeClass(" effect");
		$("#Buscategory").removeClass(" effect");
		$("#Bustype").removeClass(" effect");

		$("#User").removeClass(" effect");
		$("#bus").removeClass(" effect");
		$("#pass").removeClass(" effect");
		$("#city").removeClass(" effect");
		$("#seat").removeClass(" effect");
		$("#station").removeClass(" effect");
		$("#schedule").removeClass(" effect");
		$("#route").removeClass(" effect");
		$("#registration").removeClass(" effect");
		$("#reservation").removeClass(" effect");

		$("#treeBusdetail").slideUp(300);
		$("#treeBuscategory").slideUp(300);
		$("#treeBustype").slideUp(300);
		$("#treeBus").slideUp(300);
		$("#treePass").slideUp(300);
		$("#treeCity").slideUp(300);
		$("#treeSeat").slideUp(300);
		$("#treeStation").slideUp(300);
		$("#treeSchedule").slideUp(300);
		$("#treeRoute").slideUp(300);
		$("#treeUser").slideUp(300);
		$("#treeRegistration").slideUp(300);
		$("#treeReservation").slideUp(300);

		$("#treeOrg").slideToggle(300);
		$(this).addClass(" effect");
	});

	$("#pass").click(function() {

		$("#User").removeClass(" effect");
		$("#Busdetail").removeClass(" effect");
		$("#Buscategory").removeClass(" effect");
		$("#Bustype").removeClass(" effect");

		$("#bus").removeClass(" effect");
		$("#city").removeClass(" effect");
		$("#org").removeClass(" effect");
		$("#seat").removeClass(" effect");
		$("#station").removeClass(" effect");
		$("#schedule").removeClass(" effect");
		$("#route").removeClass(" effect");
		$("#registration").removeClass(" effect");
		$("#reservation").removeClass(" effect");

		$("#treePassinner").slideUp(300);
		$("#treePasstype").slideUp(300);

		$("#treeBusdetail").slideUp(300);
		$("#treeBuscategory").slideUp(300);
		$("#treeBustype").slideUp(300);
		$("#treeBus").slideUp(300);
		$("#treeCity").slideUp(300);
		$("#treeOrg").slideUp(300);
		$("#treeSeat").slideUp(300);
		$("#treeStation").slideUp(300);
		$("#treeSchedule").slideUp(300);
		$("#treeRoute").slideUp(300);
		$("#treeUser").slideUp(300);
		$("#treeRegistration").slideUp(300);
		$("#treeReservation").slideUp(300);

		$("#treePass").slideToggle(300);
		$(this).addClass(" effect");
	});

	// inner pass
	$("#Passinner").click(function() {
		$(this).addClass(" effect");
		$("#Passtype").removeClass(" effect");

		$("#treePasstype").slideUp(300);
		$("#treePassinner").slideToggle(300);
	});

	$("#Passtype").click(function() {
		$(this).addClass(" effect");
		$("#Passinner").removeClass(" effect");

		$("#treePassinner").slideUp(300);
		$("#treePasstype").slideToggle(300);
	});

	// inner pass end

	$("#seat").click(function() {
		$("#User").removeClass(" effect");
		$("#Busdetail").removeClass(" effect");
		$("#Buscategory").removeClass(" effect");
		$("#Bustype").removeClass(" effect");

		$("#bus").removeClass(" effect");
		$("#pass").removeClass(" effect");
		$("#city").removeClass(" effect");
		$("#org").removeClass(" effect");
		$("#station").removeClass(" effect");
		$("#schedule").removeClass(" effect");
		$("#route").removeClass(" effect");
		$("#registration").removeClass(" effect");
		$("#reservation").removeClass(" effect");

		$("#treeBus").slideUp(300);
		$("#treeBusdetail").slideUp(300);
		$("#treeBuscategory").slideUp(300);
		$("#treeBustype").slideUp(300);
		$("#treePass").slideUp(300);
		$("#treeCity").slideUp(300);
		$("#treeOrg").slideUp(300);
		$("#treeStation").slideUp(300);
		$("#treeSchedule").slideUp(300);
		$("#treeRoute").slideUp(300);
		$("#treeRegistration").slideUp(300);
		$("#treeUser").slideUp(300);
		$("#treeReservation").slideUp(300);

		$("#treeSeat").slideToggle(300);
		$(this).addClass(" effect");
	});
	$("#schedule").click(function() {
		$("#User").removeClass(" effect");
		$("#Busdetail").removeClass(" effect");
		$("#Buscategory").removeClass(" effect");
		$("#Bustype").removeClass(" effect");

		$("#bus").removeClass(" effect");
		$("#pass").removeClass(" effect");
		$("#city").removeClass(" effect");
		$("#org").removeClass(" effect");
		$("#seat").removeClass(" effect");
		$("#station").removeClass(" effect");
		$("#route").removeClass(" effect");
		$("#registration").removeClass(" effect");
		$("#reservation").removeClass(" effect");

		$("#treeBus").slideUp(300);
		$("#treePass").slideUp(300);
		$("#treeBusdetail").slideUp(300);
		$("#treeBuscategory").slideUp(300);
		$("#treeBustype").slideUp(300);
		$("#treeCity").slideUp(300);
		$("#treeOrg").slideUp(300);
		$("#treeSeat").slideUp(300);
		$("#treeStation").slideUp(300);
		$("#treeRoute").slideUp(300);
		$("#treeRegistration").slideUp(300);
		$("#treeUser").slideUp(300);
		$("#treeReservation").slideUp(300);

		$("#treeSchedule").slideToggle(300);
		$(this).addClass(" effect");
	});
	$("#route").click(function() {
		$("#User").removeClass(" effect");
		$("#Busdetail").removeClass(" effect");
		$("#Buscategory").removeClass(" effect");
		$("#Bustype").removeClass(" effect");

		$("#bus").removeClass(" effect");
		$("#pass").removeClass(" effect");
		$("#city").removeClass(" effect");
		$("#org").removeClass(" effect");
		$("#seat").removeClass(" effect");
		$("#station").removeClass(" effect");
		$("#schedule").removeClass(" effect");
		$("#registration").removeClass(" effect");
		$("#reservation").removeClass(" effect");

		$("#treeBusdetail").slideUp(300);
		$("#treeBuscategory").slideUp(300);
		$("#treeBustype").slideUp(300);
		$("#treeBus").slideUp(300);
		$("#treePass").slideUp(300);
		$("#treeCity").slideUp(300);
		$("#treeOrg").slideUp(300);
		$("#treeSeat").slideUp(300);
		$("#treeStation").slideUp(300);
		$("#treeSchedule").slideUp(300);
		$("#treeRegistration").slideUp(300);
		$("#treeUser").slideUp(300);
		$("#treeReservation").slideUp(300);

		$("#treeRoute").slideToggle(300);
		$(this).addClass(" effect");
	});

	$("#station").click(function() {
		$("#User").removeClass(" effect");
		$("#Busdetail").removeClass(" effect");
		$("#Buscategory").removeClass(" effect");
		$("#Bustype").removeClass(" effect");

		$("#bus").removeClass(" effect");
		$("#pass").removeClass(" effect");
		$("#city").removeClass(" effect");
		$("#org").removeClass(" effect");
		$("#seat").removeClass(" effect");
		$("#schedule").removeClass(" effect");
		$("#route").removeClass(" effect");
		$("#registration").removeClass(" effect");
		$("#reservation").removeClass(" effect");

		$("#treeBus").slideUp(300);
		$("#treeBusdetail").slideUp(300);
		$("#treeBuscategory").slideUp(300);
		$("#treeBustype").slideUp(300);
		$("#treePass").slideUp(300);
		$("#treeCity").slideUp(300);
		$("#treeOrg").slideUp(300);
		$("#treeSeat").slideUp(300);
		$("#treeSchedule").slideUp(300);
		$("#treeRoute").slideUp(300);
		$("#treeRegistration").slideUp(300);
		$("#treeReservation").slideUp(300);
		$("#treeUser").slideUp(300);
		$("#treeStation").slideToggle(300);
		$(this).addClass(" effect");
	});

});