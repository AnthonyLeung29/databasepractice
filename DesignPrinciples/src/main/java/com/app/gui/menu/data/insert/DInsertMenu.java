package com.app.gui.menu.data.insert;

import javax.swing.JMenu;

/**
 * The submenu for the data menu option.
 * 
 * @author antho
 *
 */
@SuppressWarnings("serial")
public class DInsertMenu extends JMenu {
	
	private static final String DISPLAY_NAME = "Insert";
	
	public DInsertMenu() {
		super(DISPLAY_NAME);
		initialize();
	}
	
	private void initialize() {
		super.add(new DInsertMenuBook());
		super.add(new DInsertMenuMusic());
		super.add(new DInsertMenuMovie());
	}
}
