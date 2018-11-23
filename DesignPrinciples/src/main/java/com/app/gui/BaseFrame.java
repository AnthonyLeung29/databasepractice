package com.app.gui;

import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * An abstract class that mandates the starting and closing of a frame.
 * Allows for default operations to be set such as the default close operation 
 * and the minimum size
 * 
 * @author antho
 *
 */
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
	
	public void update() {
		super.revalidate();
		super.repaint();
	}
	
	public void close() {
		super.setVisible(false);
		super.dispose();
	}
}
