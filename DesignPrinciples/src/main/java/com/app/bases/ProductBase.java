package com.app.bases;

import java.lang.reflect.Field;
import java.util.ArrayList;
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
	
	protected abstract List<Object> getRestOfAttributeValues();
	
	@Override
	public List<String> getAttributes() {
		List<String> attributes = new ArrayList<String>();
		Field[] fields = getClass().getFields();
		
		for (Field f : fields) {
			attributes.add(f.getName());
		}
		
		return attributes;
	}
	
	@Override
	public List<Object> getAttributeValues() {
		List<Object> base = Arrays.asList(name, year);
		List<Object> rest = getRestOfAttributeValues();
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
