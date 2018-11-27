package com.app.gui.menu.report;

import java.awt.event.ActionEvent;

import com.app.bases.MenuItemBase;

@SuppressWarnings("serial")
public class Report2 extends MenuItemBase {

	private final static String DISPLAY_NAME = "Publications in one year";
	
	public Report2() {
		super(DISPLAY_NAME);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Generate report
		// TODO Show the table
	}
}