package com.app.product;

import java.util.ArrayList;
import java.util.List;

public enum BookCol implements DbCol {
	NAME("Name"),
	YEAR("Year Of Publication"),
	ISBN("ISBN Number"),
	PUBLISHER("Publisher Name"),
	NUMBER_OF_PAGES("Number of Pages"),
	DESCRIPTION("Description"),
	EDITION_NUMBER("Edition Number"),
	AUTHOR1("Author 1 (Surname, first, last)"),
	AUTHOR2("Author 2 (Surname, first, last)"),
	AUTHOR3("Author 3 (Surname, first, last)"),
	AUTHOR4("Author 4 (Surname, first, last)"),
	AUTHOR5("Author 5 (Surname, first, last)");
	
	private String displayName;
	
	private BookCol(String displayName) {
		this.displayName = displayName;
	}
	
	public String getDisplayName() {
		return this.displayName;
	}
	
	// Only used once atm
	public static List<String> getDisplayNames() {
		List<String> names = new ArrayList<String>();
		BookCol[] values = BookCol.values();
		
		for (BookCol value : values) {
			names.add(value.getDisplayName());
		}
		
		return names;
	}
}
