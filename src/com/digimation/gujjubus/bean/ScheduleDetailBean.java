package com.digimation.gujjubus.bean;

public class ScheduleDetailBean {

private Integer scheduleDetailId;
private Integer scheduleId;
private Integer sourceId;
private Integer destinationId;
private String source;
private String destination;
private Integer weekOfDay;
private String offDate;
private Integer distance;
private String BusNo;
private String arrivalTime;
private String departureTime;
private String reachTime;
private Integer timeTaken;
private Integer busDetailId;

public Integer getBusDetailId() {
	return busDetailId;
}
public void setBusDetailId(Integer busDetailId) {
	this.busDetailId = busDetailId;
}
public String getReachTime() {
	return reachTime;
}
public void setReachTime(String reachTime) {
	this.reachTime = reachTime;
}
public String getArrivalTime() {
	return arrivalTime;
}
public void setArrivalTime(String arrivalTime) {
	this.arrivalTime = arrivalTime;
}
public String getDepartureTime() {
	return departureTime;
}
public void setDepartureTime(String departureTime) {
	this.departureTime = departureTime;
}
public Integer getTimeTaken() {
	return timeTaken;
}
public void setTimeTaken(Integer timeTaken) {
	this.timeTaken = timeTaken;
}
public String getBusNo() {
	return BusNo;
}
public void setBusNo(String busNo) {
	BusNo = busNo;
}
public Integer getScheduleDetailId() {
	return scheduleDetailId;
}
public void setScheduleDetailId(Integer scheduleDetailId) {
	this.scheduleDetailId = scheduleDetailId;
}
public Integer getScheduleId() {
	return scheduleId;
}
public void setScheduleId(Integer scheduleId) {
	this.scheduleId = scheduleId;
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
public Integer getWeekOfDay() {
	return weekOfDay;
}
public void setWeekOfDay(Integer weekOfDay) {
	this.weekOfDay = weekOfDay;
}
public String getOffDate() {
	return offDate;
}
public void setOffDate(String offDate) {
	this.offDate = offDate;
}
public Integer getDistance() {
	return distance;
}
public void setDistance(Integer distance) {
	this.distance = distance;
}

}
