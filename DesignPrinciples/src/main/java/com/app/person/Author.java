package com.app.person;

import com.app.bases.PersonBase;

public class Author extends PersonBase {

	private String address;
	private int phoneNum;
	private String email;
	
	public Author(String first, String middle, String last) {
		super(first, middle, last);
	}

	public String getAddress() {
		return this.address;
	}
	
	public int getPhoneNumber() {
		return this.phoneNum;
	}
	
	public String getEmail () {
		return this.email;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setPhoneNumber(int number) {
		this.phoneNum = number;
	}
	
	public void setEmail (String email) {
		this.email = email;
	}
}
