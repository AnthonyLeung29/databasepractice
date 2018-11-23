package com.app.gui.menu;

import javax.swing.JMenuBar;

import com.app.gui.menu.data.DataMenu;

/**
 * The menu bar that initializes and adds all the menus to be shown
 * on the menubar.
 * 'DB' here stands for Database
 * 
 * @author antho
 *
 */
@SuppressWarnings("serial")
public class DBMenuBar extends JMenuBar {

	public DBMenuBar() {
		super();
		initializeMenus();
	}
	
	private void initializeMenus() {
		super.add(new DataMenu());
	}
}
