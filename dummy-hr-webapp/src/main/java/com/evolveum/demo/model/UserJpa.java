package com.evolveum.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@NamedQueries({
		@NamedQuery(name = "findAllUsers", query = "from UserJpa u "),
		@NamedQuery(name = "findUserById", query = "SELECT u FROM UserJpa u WHERE u.id = :id") })
@Table(name = "usershr")
public class UserJpa implements Serializable {

	@Id
	@Column(name = "id")
	@GeneratedValue
	private Integer id;

	private String firstname;
	private String surname;
	private Integer employeeNumber;
	private String artname;
	private String emailAddress;
	private String emptype;
	private String orgpath;
	private String responsibility;
	
	public UserJpa() {
	}

	public UserJpa(String firstname, String surname, Integer employeeNumber,
			String artname, String emptype, /*String EnumOrgTypeString,*/ String orgpath, String responsibility) {
		this.firstname = firstname;
		this.surname = surname;
		this.employeeNumber = employeeNumber;
		this.artname = artname;
		this.emptype = emptype;
		this.orgpath = orgpath;
		this.responsibility = responsibility;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
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

	public Integer getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(Integer employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getArtname() {
		return artname;
	}

	public void setArtname(String artname) {
		this.artname = artname;
	}

	public String getEmptype() {
		return emptype;
	}

	public void setEmptype(String emptype) {
		this.emptype = emptype;
	}
	
	public String getOrgType() {
		return orgpath;
	}

	public void setOrgType(String orgpath) {
		this.orgpath = orgpath;
	}
	
	public String getResponsibility() {
		return responsibility;
	}

	public void setResponsibility(String responsibility) {
		this.responsibility = responsibility;
	}
}
