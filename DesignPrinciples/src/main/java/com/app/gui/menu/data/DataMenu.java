package com.app.gui.menu.data;

import javax.swing.JMenu;

import com.app.gui.menu.data.insert.DInsertMenu;

/**
 * This is a menu on the menubar. Initializes and adds all the wanted submenus
 * for data The 'D' prefix stands for data.
 * 
 * @author antho
 *
 */
@SuppressWarnings("serial")
public class DataMenu extends JMenu {

	public DataMenu() {
		super("Data");
		initialize();
	}
	
	private void initialize() {
		super.add(new DInsertMenu());
		super.addSeparator();
	}
}
