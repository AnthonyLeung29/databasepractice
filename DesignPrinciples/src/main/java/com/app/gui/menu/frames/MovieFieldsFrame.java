package com.app.gui.menu.frames;

import com.app.database.tables.Table;

@SuppressWarnings("serial")
public class MovieFieldsFrame extends VerticalFieldsFrame {

	public enum MovieFields implements ProductFields {
		NAME("Name"),
		YEAR("Year of Release");
		
		private String displayName;
		
		private MovieFields(String displayName) {
			this.displayName = displayName;
		}
		
		@Override
		public String getDisplayName() {
			return this.displayName;
		}
	}
	
	public MovieFieldsFrame() {
		super(Table.MOVIE + " Fields", MovieFields.class.getEnumConstants());
	}

	@Override
	protected boolean submitAction() {
		// TODO Auto-generated method stub
		return false;
	}

}
