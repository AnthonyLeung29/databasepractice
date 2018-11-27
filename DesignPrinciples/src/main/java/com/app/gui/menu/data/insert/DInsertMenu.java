package com.app.gui.menu.data.insert;

import com.app.bases.MenuBase;

/**
 * The submenu for the data menu option.
 * 
 * @author antho
 *
 */
@SuppressWarnings("serial")
public class DInsertMenu extends MenuBase {
	
	private static final String DISPLAY_NAME = "Insert";
	
	public DInsertMenu() {
		super(DISPLAY_NAME);
	}
	
	protected void addItems() {
		super.add(new DInsertMenuItemBook());
		super.add(new DInsertMenuItemMusic());
		super.add(new DInsertMenuItemMovie());
	}
}
