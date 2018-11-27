package com.app.gui.menu.report;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class Report4 extends JMenuItem implements ActionListener {

	private final static String DISPLAY_NAME = "Frequent Publishers";
	
	public Report4() {
		super(DISPLAY_NAME);
		super.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Generate report
		// TODO Show the table
	}
}
