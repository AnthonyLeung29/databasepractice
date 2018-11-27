package com.app.gui.menu;

import com.app.bases.MenuBase;
import com.app.gui.menu.data.insert.DInsertMenu;
import com.app.gui.menu.data.remove.DRemoveMenuItem;
import com.app.gui.menu.data.update.DUpdateMenuItem;

/**
 * This is a menu on the menubar. Initializes and adds all the wanted submenus
 * for data The 'D' prefix stands for data.
 * 
 * @author antho
 *
 */
@SuppressWarnings("serial")
public class DataMenu extends MenuBase {

	private static final String DISPLAY_NAME = "Data";
	
	public DataMenu() {
		super(DISPLAY_NAME);
	}
	
	protected void addItems() {
		super.add(new DInsertMenu());
		super.addSeparator();
		super.add(new DUpdateMenuItem());
		super.add(new DRemoveMenuItem());
	}
}
