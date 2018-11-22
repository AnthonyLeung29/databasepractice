package com.app.gui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This launches a GUI to handle SQL queries and requests given the database connection
 * 
 * @author antho
 *
 */
public class GUIEmbeddedSQL {
	
	private JFrame frame;
	private JPanel body;

	public GUIEmbeddedSQL (String connection) {
		frame = new JFrame("Embedded SQL GUI for " + connection);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMinimumSize(new Dimension(800, 400));
	}
	
	public void start() {
		frame.setVisible(true);
		frame.pack();
		frame.setLocationRelativeTo(null);
	}
}
