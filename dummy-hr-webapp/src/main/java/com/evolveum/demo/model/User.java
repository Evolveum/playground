package com.evolveum.demo.model;

public class User {

	private Integer id;
	private String fullName;
	private String givenName;
	private String emailAddress;
	private Integer employeeNumber;
	
	public User(String fullName, String givenName, String emailAddress, Integer employeeNumber, Integer id){
		
		this.fullName = fullName;
		this.givenName = givenName;
		this.emailAddress = emailAddress;
		this.employeeNumber = employeeNumber;
		this.id = id;
	}
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getGivenName() {
		return givenName;
	}
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public Integer getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(Integer employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

}
