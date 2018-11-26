package com.app.product;

public enum MovieCol implements DbCol {
	NAME("Name");
	
	private String displayName;
	
	private MovieCol(String displayName) {
		this.displayName = displayName;
	}
	
	@Override
	public String getDisplayName() {
		return this.displayName;
	}
}
