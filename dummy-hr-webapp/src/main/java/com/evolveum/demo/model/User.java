package com.evolveum.demo.model;

import java.io.Serializable;

public class User implements Serializable{

	private Integer id;
	private String firstname;
	private String surname;
	private Integer employeeNumber;
	private String artname;
	private EmpType emptype;
	
	public User(String firstname, String surname, Integer employeeNumber, Integer id, String artname, String emptype){
		
		this.firstname = firstname;
		this.surname = surname;
		this.employeeNumber = employeeNumber;
		this.id = id;
		this.artname = artname;
		
		if(emptype.equals("FTE")){
			this.emptype = EmpType.FTE;
		}
		else if(emptype.equals("PTE")){
			this.emptype = EmpType.PTE;
		}
		else if(emptype.equals("CONTRACTOR")){
			this.emptype = EmpType.CONTRACTOR;
		}
		else if(emptype.equals("RETIRED")){
			this.emptype = EmpType.RETIRED;
		}
		
	}

	public String getArtname() {
		return artname;
	}

	public void setArtname(String artname) {
		this.artname = artname;
	}

	public String getEmptype() {
		return emptype.toString();
	}

	public void setEmptype(EmpType emptype) {
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
	



}
