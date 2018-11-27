package com.app.gui.menu;

import javax.swing.JMenu;

import com.app.gui.menu.report.Report1;

@SuppressWarnings("serial")
public class ReportMenu extends JMenu {

	public ReportMenu() {
		super("Report");
		addItems();
	}
	
	private void addItems() {
		super.add(new Report1());
	}
}
