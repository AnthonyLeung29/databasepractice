package com.app.gui.menu.view;

import java.awt.event.ActionEvent;

import com.app.bases.MenuItemBase;
import com.app.gui.menu.frames.ViewFrame;

@SuppressWarnings("serial")
public class VNewWindow extends MenuItemBase {

	private static final String DISPLAY_NAME = "Open new view window";
	
	public VNewWindow() {
		super(DISPLAY_NAME);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ViewFrame frame = new ViewFrame();
		frame.start();
	}
}
