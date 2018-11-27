package com.app.gui.menu.report;

import java.awt.event.ActionEvent;

import com.app.bases.MenuItemBase;

@SuppressWarnings("serial")
public class Report1 extends MenuItemBase {

	private final static String DISPLAY_NAME = "Authors' Publications";
	
	public Report1() {
		super(DISPLAY_NAME);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Generate report
		// TODO Show the table
	}
}
