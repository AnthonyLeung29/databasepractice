package com.app.gui.menu.data.insert;

import java.awt.event.ActionEvent;

import com.app.gui.bases.MenuItemBase;
import com.app.gui.menu.frames.MusicFieldsFrame;

@SuppressWarnings("serial")
public class DInsertMusic extends MenuItemBase {

	private static final String DISPLAY_NAME = "Music";
	
	public DInsertMusic() {
		super(DISPLAY_NAME);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MusicFieldsFrame frame = new MusicFieldsFrame();
		frame.start();
	}
}
