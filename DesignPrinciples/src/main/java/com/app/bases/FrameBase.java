package com.app.bases;

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
public abstract class FrameBase extends JFrame {

	public FrameBase(String title) {
		super(title);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setMinimumSize(new Dimension(200, 100));
		super.setResizable(false);
	}
	
	/**
	 * Makes the frame visible and packs all the current components.
	 * Also sets the frame to be at the center of the screen.
	 */
	public void start() {
		super.setVisible(true);
		super.pack();
		super.setLocationRelativeTo(null);
	}
	
	/**
	 * Revalidates all the component hierarchy in the frame
	 * and refreshes (repaints) the frame with the new components if any
	 */
	public void update() {
		super.revalidate();
		super.repaint();
	}
	
	/**
	 * Makes the frame invisible and properly disposes the resources that were used by this
	 */
	public void close() {
		super.setVisible(false);
		super.dispose();
	}
}
