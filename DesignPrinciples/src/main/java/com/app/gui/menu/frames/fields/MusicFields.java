package com.app.gui.menu.frames.fields;

public enum MusicFields implements ProductFields {
	NAME("Name");
	
	private String displayName;
	
	private MusicFields(String displayName) {
		this.displayName = displayName;
	}
	
	@Override
	public String getDisplayName() {
		return this.displayName;
	}
}
