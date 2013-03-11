package com.evolveum.demo.model;

import java.io.Serializable;

public class User implements Serializable{

	private Integer id;
	private String firstname;
	private String surname;
	private String emailAddress;
	private Integer employeeNumber;
	
	public User(String firstname, String surname, String emailAddress, Integer employeeNumber, Integer id){
		
		this.firstname = firstname;
		this.surname = surname;
		this.emailAddress = emailAddress;
		this.employeeNumber = employeeNumber;
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
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
	

	

}
