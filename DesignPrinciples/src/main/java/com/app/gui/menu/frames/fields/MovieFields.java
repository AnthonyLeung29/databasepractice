package com.app.gui.menu.frames.fields;

public enum MovieFields implements ProductFields {
	NAME("Name");
	
	private String displayName;
	
	private MovieFields(String displayName) {
		this.displayName = displayName;
	}
	
	@Override
	public String getDisplayName() {
		return this.displayName;
	}
}
