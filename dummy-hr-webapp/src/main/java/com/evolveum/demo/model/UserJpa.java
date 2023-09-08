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
	private String lastname;
	private Integer employeeNumber;
	private String artname;
	private String emailAddress;
	private String emptype;
	private String orgpath;
	private String responsibility;
	private String status;
	private String locality;
	private String ou;
	
	public UserJpa() {
	}

	public UserJpa(String firstname, String lastname, Integer employeeNumber,
				   String artname, String emptype, /*String EnumOrgTypeString,*/ String orgpath, String responsibility,
				   String status, String locality, String ou) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.employeeNumber = employeeNumber;
		this.artname = artname;
		this.emptype = emptype;
		this.orgpath = orgpath;
		this.responsibility = responsibility;
		this.status = status;
		this.locality = locality;
		this.ou = ou;
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

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getOu() {
		return ou;
	}

	public void setOu(String ou) {
		this.ou = ou;
	}
}
