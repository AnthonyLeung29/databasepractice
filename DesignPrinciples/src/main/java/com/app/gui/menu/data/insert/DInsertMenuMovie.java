package com.app.gui.menu.data.insert;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import com.app.gui.menu.frames.VerticalFieldsFrame;
import com.app.product.MovieCol;

@SuppressWarnings("serial")
public class DInsertMenuMovie extends JMenuItem implements ActionListener {

	public DInsertMenuMovie() {
		super("Movie");
		super.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		VerticalFieldsFrame frame = new VerticalFieldsFrame("Movie Fields", MovieCol.class.getEnumConstants());
		frame.start();
	}
}
