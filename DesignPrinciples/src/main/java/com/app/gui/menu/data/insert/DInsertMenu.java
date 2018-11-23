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
	
	public DInsertMenu() {
		super("Insert");
		initialize();
	}
	
	private void initialize() {
		super.add(new DInsertMenuBook());
		super.add(new DInsertMenuMusic());
		super.add(new DInsertMenuMovie());
	}
}
