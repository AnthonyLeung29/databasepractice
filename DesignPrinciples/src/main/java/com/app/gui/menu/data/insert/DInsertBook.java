package com.app.gui.menu.data.insert;

import java.awt.event.ActionEvent;

import com.app.gui.bases.MenuItemBase;
import com.app.gui.menu.frames.BookFieldsFrame;

@SuppressWarnings("serial")
public class DInsertBook extends MenuItemBase {
	
	private static final String DISPLAY_NAME = "Book";
	
	public DInsertBook() {
		super(DISPLAY_NAME);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		BookFieldsFrame frame = new BookFieldsFrame();
		frame.start();
	}
}
