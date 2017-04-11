package com.digimation.gujjubus.bean;

public class ReservationDetailBean {
	private Integer reservationId;
	private String seatNo[]=new String[5];
	private Integer seatNum;
	private Integer seatTypeId;
	private Integer amount;
	private Integer distance;
	private Integer noOfSeat;
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String source;
	private String destination;
	private String busNo;
	private String journeyDate;
	
	
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getDistance() {
		return distance;
	}
	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	public Integer getNoOfSeat() {
		return noOfSeat;
	}
	public void setNoOfSeat(Integer noOfSeat) {
		this.noOfSeat = noOfSeat;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getBusNo() {
		return busNo;
	}
	public void setBusNo(String busNo) {
		this.busNo = busNo;
	}
	public String getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(String journeyDate) {
		this.journeyDate = journeyDate;
	}
	public Integer getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(Integer seatNum) {
		this.seatNum = seatNum;
	}
	public String[] getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(String[] seatNo) {
		this.seatNo = seatNo;
	}
	public Integer getReservationId() {
		return reservationId;
	}
	public void setReservationId(Integer reservationId) {
		this.reservationId = reservationId;
	}
	public Integer getSeatTypeId() {
		return seatTypeId;
	}
	public void setSeatTypeId(Integer seatTypeId) {
		this.seatTypeId = seatTypeId;
	}
	
}
