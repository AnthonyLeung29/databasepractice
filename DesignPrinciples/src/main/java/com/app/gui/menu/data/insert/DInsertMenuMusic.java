package com.app.gui.menu.data.insert;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import com.app.gui.menu.frames.VerticalFieldsFrame;
import com.app.product.MusicCol;

@SuppressWarnings("serial")
public class DInsertMenuMusic extends JMenuItem implements ActionListener {

	public DInsertMenuMusic() {
		super("Music");
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		VerticalFieldsFrame frame = new VerticalFieldsFrame("Music Fields", MusicCol.class.getEnumConstants());
		frame.start();
	}
}
