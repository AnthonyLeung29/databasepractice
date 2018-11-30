package com.app.gui.menu.data.insert;

import java.awt.event.ActionEvent;

import com.app.gui.bases.MenuItemBase;
import com.app.gui.menu.frames.VerticalFieldsFrame;
import com.app.product.MovieCol;

@SuppressWarnings("serial")
public class DInsertMovie extends MenuItemBase {

	private static final String DISPLAY_NAME = "Movie";
	
	public DInsertMovie() {
		super(DISPLAY_NAME);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		VerticalFieldsFrame frame = new VerticalFieldsFrame(DISPLAY_NAME + " Fields", MovieCol.class.getEnumConstants());
		frame.start();
	}
}
