package com.evolveum.demo.model;

import java.io.Serializable;

import com.evolveum.demo.model.EnumOrgTypeToString.EnumOrgType;

public class User implements Serializable {

	/* added new column 'orgpath' and 'responsibility' */
	// //////////////////////////////////////////////////////////////////////////////////////

	private Integer id;
	private String firstname;
	private String surname;
	private Integer employeeNumber;
	private String artname;
	private EnumEmpType emptype;
	private EnumOrgType orgpath;
	private String responsibility;

	public User(String firstname, String surname, Integer employeeNumber,
			Integer id, String artname, String emptype, String orgpath,
			String responsibility) {

		this.firstname = firstname;
		this.surname = surname;
		this.employeeNumber = employeeNumber;
		this.id = id;
		this.artname = artname;
		this.responsibility = responsibility;

		if (emptype.equals("FTE")) {
			this.emptype = EnumEmpType.FTE;
		} else if (emptype.equals("PTE")) {
			this.emptype = EnumEmpType.PTE;
		} else if (emptype.equals("CONTRACTOR")) {
			this.emptype = EnumEmpType.CONTRACTOR;
		} else if (emptype.equals("RETIRED")) {
			this.emptype = EnumEmpType.RETIRED;
		} 

		if (orgpath
				.equals("Apprentice/Armory Department/Military Department/Grand Master")) {
			this.orgpath = EnumOrgType.ApprenticeArmory;
		} else if (orgpath
				.equals("Apprentice/Weapons Department/Military Department/Grand Master")) {
			this.orgpath = EnumOrgType.ApprenticeWeapons;
		} else if (orgpath
				.equals("Apprentice/Buildings Department/Civil Department/Grand Master")) {
			this.orgpath = EnumOrgType.ApprenticeBuildings;
		} else if (orgpath
				.equals("Apprentice/Artefacts Department/Civil Department/Grand Master")) {
			this.orgpath = EnumOrgType.ApprenticeArtefacts;
		} else if (orgpath
				.equals("Armory Department/Military Department/Grand Master")) {
			this.orgpath = EnumOrgType.MasterArmory;
		} else if (orgpath
				.equals("Weapons Department/Military Department/Grand Master")) {
			this.orgpath = EnumOrgType.MasterWeapons;
		} else if (orgpath
				.equals("Buildings Department/Civil Department/Grand Master")) {
			this.orgpath = EnumOrgType.MasterBuildings;
		} else if (orgpath
				.equals("Artefacts Department/Civil Department/Grand Master")) {
			this.orgpath = EnumOrgType.MasterArtefacts;
		} else if (orgpath.equals("Military Department/Grand Master")) {
			this.orgpath = EnumOrgType.MasterMilitary;
		} else if (orgpath.equals("Civil Department/Grand Master")) {
			this.orgpath = EnumOrgType.MasterCivil;
		} else if (orgpath.equals("Grand Master")) {
			this.orgpath = EnumOrgType.GrandMaster;
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

	public void setEnumEmptype(EnumEmpType emptype) {
		this.emptype = emptype;
	}

	public String getEnumOrgType() {
		return orgpath.toString();
	}

	public void setEnumOrgType(EnumOrgType orgpath) {
		this.orgpath = orgpath;
	}

	public String getResponsibility() {
		return responsibility.toString();
	}

	public void setResponsibilities(String responsibility) {
		this.responsibility = responsibility;
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

	/* old variant without new column 'orgpath' */
	// //////////////////////////////////////////////////////////////////////////////////////
	/*
	 * private Integer id; private String firstname; private String surname;
	 * private Integer employeeNumber; private String artname; private EmpType
	 * emptype;
	 * 
	 * public User(String firstname, String surname, Integer employeeNumber,
	 * Integer id, String artname, String emptype) {
	 * 
	 * this.firstname = firstname; this.surname = surname; this.employeeNumber =
	 * employeeNumber; this.id = id; this.artname = artname;
	 * 
	 * if (emptype.equals("FTE")) { this.emptype = EmpType.FTE; } else if
	 * (emptype.equals("PTE")) { this.emptype = EmpType.PTE; } else if
	 * (emptype.equals("CONTRACTOR")) { this.emptype = EmpType.CONTRACTOR; }
	 * else if (emptype.equals("RETIRED")) { this.emptype = EmpType.RETIRED; } }
	 * 
	 * public String getArtname() { return artname; }
	 * 
	 * public void setArtname(String artname) { this.artname = artname; }
	 * 
	 * public String getEmptype() { return emptype.toString(); }
	 * 
	 * public void setEmptype(EmpType emptype) { this.emptype = emptype; }
	 * 
	 * public Integer getId() { return id; }
	 * 
	 * public void setId(Integer id) { this.id = id; }
	 * 
	 * public String getFirstname() { return firstname; }
	 * 
	 * public void setFirstname(String firstname) { this.firstname = firstname;
	 * }
	 * 
	 * public String getSurname() { return surname; }
	 * 
	 * public void setSurname(String surname) { this.surname = surname; }
	 * 
	 * public Integer getEmployeeNumber() { return employeeNumber; }
	 * 
	 * public void setEmployeeNumber(Integer employeeNumber) {
	 * this.employeeNumber = employeeNumber; }
	 */
}
