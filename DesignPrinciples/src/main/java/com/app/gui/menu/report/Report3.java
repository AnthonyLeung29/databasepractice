package com.app.gui.menu.report;

import java.awt.event.ActionEvent;

import com.app.gui.bases.MenuItemBase;

@SuppressWarnings("serial")
public class Report3 extends MenuItemBase {

	private final static String DISPLAY_NAME = "Books with Similar Topic";
	
	public Report3() {
		super(DISPLAY_NAME);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Generate report
		// TODO Show the table
	}
}
