package com.evolveum.demo.model;

import java.io.Serializable;
import java.util.Date;

public class People implements Serializable{

	private String username;
	private String first_name;
	private String last_name;
	private String tel_number;
	private String fax_number;
	private String office_id;
	private Integer floor;
	private String street_address;
	private String city;
	private String country;
	private String postal_code;
	private boolean validity;
	private Date created;
	private Date modified;
	private String password;
	
	public People(	
				String username,
				String first_name,
				String last_name,
				String tel_number,
				String fax_number,
				String office_id,
				Integer floor,
				String street_address,
				String city,
				String country,
				String postal_code,
				boolean validity,
				Date created,
				Date modified,
				String password){
		
		this.username = username;
		this.first_name = first_name;
		this.last_name = last_name;
		this.tel_number = tel_number;
		this.fax_number = fax_number;
		this.office_id = office_id;
		this.floor = floor;
		this.street_address = street_address;
		this.city = city;
		this.country = country;
		this.postal_code = postal_code;
		this.validity = validity;
		this.created = created;
		this.modified = modified;
		this.password = password;
		
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getTel_number() {
		return tel_number;
	}

	public void setTel_number(String tel_number) {
		this.tel_number = tel_number;
	}

	public String getFax_number() {
		return fax_number;
	}

	public void setFax_number(String fax_number) {
		this.fax_number = fax_number;
	}

	public String getOffice_id() {
		return office_id;
	}

	public void setOffice_id(String office_id) {
		this.office_id = office_id;
	}

	public Integer getFloor() {
		return floor;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	public String getStreet_address() {
		return street_address;
	}

	public void setStreet_address(String street_address) {
		this.street_address = street_address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostal_code() {
		return postal_code;
	}

	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}

	public boolean isValidity() {
		return validity;
	}

	public void setValidity(boolean validity) {
		this.validity = validity;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

}
