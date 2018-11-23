package com.app.bases;

public abstract class PersonBase {

	private String firstname;
	private String middlename;
	private String lastname;

	public PersonBase(String first, String middle, String last) {
		this.firstname = first;
		this.middlename = middle;
		this.lastname = last;
	}
	
	/**
	 * Gets the full name in the form of "First Middle Last"
	 * 
	 * @return
	 */
	public String getFullName() {
		return getFirstName() + " " + getMiddleName() + " " + getLastName();
	} 
	
	public String getFirstName() {
		return this.firstname;
	}
	
	public String getMiddleName() {
		return this.middlename;
	}
	
	public String getLastName() {
		return this.lastname;
	}
	
	public void setFirstName(String first) {
		this.firstname = first;
	}
	
	public void setMiddleName(String middle) {
		this.middlename = middle;
	}
	
	public void setLastName(String last) {
		this.lastname = last;
	}
}
