package com.app.gui;

import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * This launches a GUI to handle SQL queries and requests given the database connection
 * 
 * @author antho
 *
 */
@SuppressWarnings("serial")
public class MainMenuSQL extends BaseFrame {
	
	private BoxLayout layout;
	private JLabel help;

	public MainMenuSQL (String connection) {
		super("Embedded SQL GUI for " + connection);
		
		layout = new BoxLayout(super.getContentPane(), BoxLayout.PAGE_AXIS);
		super.setLayout(layout);
		
		String msg = "<html> Welcome! <br> "
				+ "Please click one of the options in the top "
				+ "left menu to get started :) </html>";
		help = new JLabel(msg);
    	Font oldFont = help.getFont();
    	Font newFont = new Font(oldFont.getName(), oldFont.getStyle(), 25);
		help.setFont(newFont);
    	
		add(help);
	}
}
