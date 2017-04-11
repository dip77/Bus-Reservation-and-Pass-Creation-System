package com.digimation.gujjubus.bean;

public class BusDetailBean {
private String busNo;
private Integer routeid;
private Integer busDetailid;
private String isAvailable;
private String source;
private String destination;

public Integer getBusDetailid() {
	return busDetailid;
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
public void setBusDetailid(Integer busDetailid) {
	this.busDetailid = busDetailid;
}
public String getBusNo() {
	return busNo;
}
public void setBusNo(String busNo) {
	this.busNo = busNo;
}
public Integer getRouteid() {
	return routeid;
}
public void setRouteid(Integer routeid) {
	this.routeid = routeid;
}
public String getIsAvailable() {
	return isAvailable;
}
public void setIsAvailable(String isAvailable) {
	this.isAvailable = isAvailable;
}


}
