package com.app.gui.menu.data.insert;

import java.awt.event.ActionEvent;

import com.app.gui.bases.MenuItemBase;
import com.app.gui.menu.frames.VerticalFieldsFrame;
import com.app.product.MusicCol;

@SuppressWarnings("serial")
public class DInsertMusic extends MenuItemBase {

	private static final String DISPLAY_NAME = "Music";
	
	public DInsertMusic() {
		super(DISPLAY_NAME);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		VerticalFieldsFrame frame = new VerticalFieldsFrame(DISPLAY_NAME + " Fields", MusicCol.class.getEnumConstants());
		frame.start();
	}
}
