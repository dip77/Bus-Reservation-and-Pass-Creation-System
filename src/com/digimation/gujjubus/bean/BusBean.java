package com.digimation.gujjubus.bean;

public class BusBean {
private String busNo;
private Integer Capacity;
private String isAvailable;
private Integer busTypeId;
private Integer busCategoryId;
private Integer busDepoId;
private String busDepo;
private String busType;
private String busCategory;

public Integer getBusTypeId() {
	return busTypeId;
}
public String getBusDepo() {
	return busDepo;
}
public void setBusDepo(String busDepo) {
	this.busDepo = busDepo;
}
public String getBusType() {
	return busType;
}
public void setBusType(String busType) {
	this.busType = busType;
}
public String getBusCategory() {
	return busCategory;
}
public void setBusCategory(String busCategory) {
	this.busCategory = busCategory;
}
public void setBusTypeId(Integer busTypeId) {
	this.busTypeId = busTypeId;
}
public Integer getBusCategoryId() {
	return busCategoryId;
}
public void setBusCategoryId(Integer busCategoryId) {
	this.busCategoryId = busCategoryId;
}
public Integer getBusDepoId() {
	return busDepoId;
}
public void setBusDepoId(Integer busDepoId) {
	this.busDepoId = busDepoId;
}
public String getBusNo() {
	return busNo;
}
public void setBusNo(String busNo) {
	this.busNo = busNo;
}
public Integer getCapacity() {
	return Capacity;
}
public void setCapacity(Integer capacity) {
	Capacity = capacity;
}
public String getIsAvailable() {
	return isAvailable;
}
public void setIsAvailable(String isAvailable) {
	this.isAvailable = isAvailable;
}

}
