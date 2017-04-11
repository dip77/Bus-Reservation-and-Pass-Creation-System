package com.digimation.gujjubus.bean;


public class PassDetailBean {
	private Integer passId;
	private Integer passDetailId;
	private Integer validity;
	private Integer totalAmount;
	private Integer termValidity;
	private  String organizationName;
	private  String organizationAddress;
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String source;
	private String destination;
	private String startDate;
	private String endDate;
	private String startTermDate;
	private String endTermDate;
	private String photo;
 	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getStartTermDate() {
		return startTermDate;
	}
	public void setStartTermDate(String startTermDate) {
		this.startTermDate = startTermDate;
	}
	public String getEndTermDate() {
		return endTermDate;
	}
	public void setEndTermDate(String endTermDate) {
		this.endTermDate = endTermDate;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public String getOrganizationAddress() {
		return organizationAddress;
	}
	public void setOrganizationAddress(String organizationAddress) {
		this.organizationAddress = organizationAddress;
	}
	public Integer getTermValidity() {
		return termValidity;
	}
	public void setTermValidity(Integer termValidity) {
		this.termValidity = termValidity;
	}
	public Integer getPassId() {
		return passId;
	}
	public void setPassId(Integer passId) {
		this.passId = passId;
	}
	public Integer getPassDetailId() {
		return passDetailId;
	}
	public void setPassDetailId(Integer passDetailId) {
		this.passDetailId = passDetailId;
	}
	public Integer getValidity() {
		return validity;
	}
	public void setValidity(Integer validity) {
		this.validity = validity;
	}
	public Integer getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}
	
}
