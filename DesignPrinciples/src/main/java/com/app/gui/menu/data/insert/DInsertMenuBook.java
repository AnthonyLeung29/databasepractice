package com.app.gui.menu.data.insert;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import com.app.gui.menu.data.frames.BookFieldsFrame;

@SuppressWarnings("serial")
public class DInsertMenuBook extends JMenuItem implements ActionListener {

	public DInsertMenuBook() {
		super("Book");
		super.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		BookFieldsFrame test = new BookFieldsFrame();
		test.start();
	}
}
