package com.evolveum.midpoint;

import org.apache.wicket.IClusterable;

public class Contact implements IClusterable {
	private static final long serialVersionUID = 1L;

	private long id;
	private String firstName;
	private String lastName;
	private String homePhone;
	private String cellPhone;

	public Contact() {

	}

	public String toString() {
		return "[Contact id=" + id + " firstName=" + firstName + " lastName=" + lastName + " homePhone="
				+ homePhone + " cellPhone=" + cellPhone + "]";
	}

	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (obj instanceof Contact) {
			Contact other = (Contact) obj;
			return other.getFirstName().equals(getFirstName()) && other.getLastName().equals(getLastName())
					&& other.getHomePhone().equals(getHomePhone())
					&& other.getCellPhone().equals(getCellPhone());

		} else {
			return false;
		}
	}

	public Contact(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
}
