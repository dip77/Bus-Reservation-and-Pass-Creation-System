package com.digimation.gujjubus.bean;

public class ReservationBean {
private Integer reservationId;
private Integer userId;
private Integer sourceId;
private Integer destinationId;
private Integer totalAmount;
private String busNo;
private String isCancel;
private String source;
private String destination;
private Integer distance;
private Integer noOfSeat;
private String journeyDate;
private String firstName;
private String middleName;
private String lastName;
private String email;


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
public String getJourneyDate() {
	return journeyDate;
}
public void setJourneyDate(String journeyDate) {
	
	this.journeyDate = journeyDate.replaceAll("-", "/");
}
public Integer getNoOfSeat() {
	return noOfSeat;
}
public void setNoOfSeat(Integer noOfSeat) {
	this.noOfSeat = noOfSeat;
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
public void setBusNo(String busNo) {
	this.busNo = busNo;
}
public void setDistance(Integer distance) {
	this.distance = distance;
}
public Integer getReservationId() {
	return reservationId;
}
public void setReservationId(Integer reservationId) {
	this.reservationId = reservationId;
}
public Integer getUserId() {
	return userId;
}
public void setUserId(Integer userId) {
	this.userId = userId;
}
public Integer getSourceId() {
	return sourceId;
}
public void setSourceId(Integer sourceId) {
	this.sourceId = sourceId;
}
public Integer getDestinationId() {
	return destinationId;
}
public void setDestinationId(Integer destinationId) {
	this.destinationId = destinationId;
}
public Integer getTotalAmount() {
	return totalAmount;
}
public void setTotalAmount(Integer totalAmount) {
	this.totalAmount = totalAmount;
}
public String getBusNo() {
	return busNo;
}
public String getIsCancel() {
	return isCancel;
}
public void setIsCancel(String isCancel) {
	this.isCancel = isCancel;
}
public int getDistance() {
	return distance;
}
public void setDistance(int distance) {
	this.distance = distance;
}


}
