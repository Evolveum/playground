package com.evolveum.demo.model;

import java.io.Serializable;

public class User implements Serializable {

	private Integer id;
	private String firstname;
	private String surname;
	private Integer employeeNumber;
	private String artname;
	private EmpType emptype;
	private Status status;
	private String locality;
	/*private String ou;*/
	private String country;
	private String job;

	public User(String firstname, String surname, Integer employeeNumber,
				Integer id, String artname, String emptype, String status, String locality, /*String ou,*/
				String country, String job) {

		this.firstname = firstname;
		this.surname = surname;
		this.employeeNumber = employeeNumber;
		this.id = id;
		this.artname = artname;
		this.locality = locality;
		this.country = country;
		this.job = job;

		for(EmpType e : EmpType.values()){
			if(e.label.equalsIgnoreCase(emptype)){
				this.emptype = e;
			}
		}

		for(Status s : Status.values()){
			if(s.label.equalsIgnoreCase(status)){
				this.status = s;
			}
		}

	}

	public String getArtname() {
		return artname;
	}

	public void setArtname(String artname) {
		this.artname = artname;
	}

	public String getEnumEmptype() {
		return emptype.toString();
	}

	public void setEnumEmptype(EmpType emptype) {
		this.emptype = emptype;
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

/*	public String getOu() {
		return ou;
	}

	public void setOu(String ou) {
		this.ou = ou;
	}*/

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
