package com.app.gui;

import java.awt.Dimension;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public abstract class BaseFrame extends JFrame {

	public BaseFrame(String title) {
		super(title);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setMinimumSize(new Dimension(800, 400));
	}
	
	public void start() {
		super.setVisible(true);
		super.pack();
		super.setLocationRelativeTo(null);
	}
	
	public void close() {
		super.setVisible(false);
		super.dispose();
	}
}
