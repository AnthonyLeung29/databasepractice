package com.app.gui;

import javax.swing.JMenuBar;

import com.app.gui.menu.DataMenu;
import com.app.gui.menu.ReportMenu;
import com.app.gui.menu.ViewMenu;

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
		this.addMenus();
	}
	
	private void addMenus() {
		super.add(new DataMenu());
		super.add(new ViewMenu());
		super.add(new ReportMenu());
	}
}
