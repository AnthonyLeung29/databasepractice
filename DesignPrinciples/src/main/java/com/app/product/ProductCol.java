package com.app.product;

public enum ProductCol {
	BOOK("Book"),
	MUSIC("Music"),
	MOVIE("Movie");
	
	private String name;
	
	private ProductCol(String name) {
		this.name = name;
	}
	
	public String getDisplayName() {
		return this.name;
	}
	// Fun task? find an algorithm to find common attributes of all 3 tables?
}
