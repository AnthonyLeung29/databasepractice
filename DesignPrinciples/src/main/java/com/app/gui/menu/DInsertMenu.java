package com.app.gui.menu;

import com.app.gui.bases.MenuBase;
import com.app.gui.menu.data.insert.DInsertBook;
import com.app.gui.menu.data.insert.DInsertMovie;
import com.app.gui.menu.data.insert.DInsertMusic;

/**
 * The submenu for the data menu option. <br>
 * The 'D' prefix stands for Data and this is the convention for any submenus or items of this menu
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
		super.add(new DInsertBook());
		super.add(new DInsertMusic());
		super.add(new DInsertMovie());
	}
}
