package com.app.gui.menu;

import com.app.bases.MenuBase;
import com.app.gui.menu.view.ViewWindowMenuItem;

@SuppressWarnings("serial")
public class ViewMenu extends MenuBase {

	private static final String DISPLAY_NAME = "View";
	
	public ViewMenu() {
		super(DISPLAY_NAME);
	}
	
	protected void addItems() {
		super.add(new ViewWindowMenuItem());
	}
}
