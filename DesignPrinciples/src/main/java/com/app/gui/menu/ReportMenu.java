package com.app.gui.menu;

import javax.swing.JMenu;

import com.app.gui.menu.report.Report1;
import com.app.gui.menu.report.Report10;
import com.app.gui.menu.report.Report2;
import com.app.gui.menu.report.Report3;
import com.app.gui.menu.report.Report4;
import com.app.gui.menu.report.Report5;
import com.app.gui.menu.report.Report6;
import com.app.gui.menu.report.Report7;
import com.app.gui.menu.report.Report8;
import com.app.gui.menu.report.Report9;

@SuppressWarnings("serial")
public class ReportMenu extends JMenu {

	public ReportMenu() {
		super("Report");
		this.addItems();
	}
	
	private void addItems() {
		super.add(new Report1());
		super.add(new Report2());
		super.add(new Report3());
		super.add(new Report4());
		super.add(new Report5());
		super.add(new Report6());
		super.add(new Report7());
		super.add(new Report8());
		super.add(new Report9());
		super.add(new Report10());
	}
}
