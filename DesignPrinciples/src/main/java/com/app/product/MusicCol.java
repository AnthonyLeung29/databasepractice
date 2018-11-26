package com.app.product;

public enum MusicCol implements DbCol {
	NAME("Name");
	
	private String displayName;
	
	private MusicCol(String displayName) {
		this.displayName = displayName;
	}
	
	@Override
	public String getDisplayName() {
		return this.displayName;
	}
}
