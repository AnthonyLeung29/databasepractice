package com.app.gui.menu.data.insert;

import java.awt.event.ActionEvent;

import com.app.bases.MenuItemBase;
import com.app.gui.menu.frames.VerticalFieldsFrame;
import com.app.product.BookCol;

@SuppressWarnings("serial")
public class DInsertBook extends MenuItemBase {
	
	private static final String DISPLAY_NAME = "Book";
	
	public DInsertBook() {
		super(DISPLAY_NAME);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		VerticalFieldsFrame frame = new VerticalFieldsFrame(DISPLAY_NAME + " Fields", BookCol.class.getEnumConstants());
		frame.start();
	}
}
