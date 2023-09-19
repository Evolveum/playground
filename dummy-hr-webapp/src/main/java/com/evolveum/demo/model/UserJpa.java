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
	private String emptype;
	private String status;
	private String locality;
//	private String ou;
	private String country;
	private String job;
	
	public UserJpa() {
	}

	public UserJpa(String firstname, String surname, Integer employeeNumber,
				   String artname, String emptype, String status, String locality,
					/*String ou,*/String country, String job) {
		this.firstname = firstname;
		this.surname = surname;
		this.employeeNumber = employeeNumber;
		this.artname = artname;
		this.emptype = emptype;
		this.status = status;
		this.locality = locality;
		this.country = country;
		this.job = job;
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

//	public String getOu() {
//		return ou;
//	}
//
//	public void setOu(String ou) {
//		this.ou = ou;
//	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
}
