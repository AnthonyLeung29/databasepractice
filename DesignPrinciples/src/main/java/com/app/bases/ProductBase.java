package com.app.bases;

import java.util.Arrays;
import java.util.List;

public abstract class ProductBase implements Product {

	// Required parameters
	private String name;
	private int year; // Only 4 digits and positive
	
	public ProductBase(String name, int year) {
		setName(name);
		setYear(year);
	}
	
	protected abstract List<Object> getRestOfAttributes();
	
	@Override
	public List<Object> getAttributes() {
		List<Object> base = Arrays.asList(name, year);
		List<Object> rest = getRestOfAttributes();
		base.addAll(rest);
		return base;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getYear() {
		return this.year;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
}
