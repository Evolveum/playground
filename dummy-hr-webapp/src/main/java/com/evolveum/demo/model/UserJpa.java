package com.evolveum.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="usershr")
public class UserJpa implements Serializable{

	@Id
	@Column(name="id")
	@GeneratedValue
	private Integer id;
	
	private String firstname;
	private String surname;
	private Integer employeeNumber;
	private String artname;
	private String emailAddress;
	private String emptype;
	
	
	public UserJpa(String firstname, String surname, Integer employeeNumber, String artname, String emptype){
		this.firstname = firstname;
		this.surname = surname;
		this.employeeNumber = employeeNumber;
		this.artname = artname;
		this.emptype = emptype;
		
	}
	
	public UserJpa(){
		super();
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
	
	
}
