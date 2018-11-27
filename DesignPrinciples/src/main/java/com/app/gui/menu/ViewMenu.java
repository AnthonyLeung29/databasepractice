package com.app.gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import com.app.gui.menu.frames.ViewFrame;

@SuppressWarnings("serial")
public class ViewMenu extends JMenu implements ActionListener {

	public ViewMenu() {
		super("View");
		this.addItems();
	}
	
	private void addItems() {
		JMenuItem open = new JMenuItem("Open view window");
		open.addActionListener(this);
		this.add(open);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ViewFrame frame = new ViewFrame();
		frame.start();
	}
}
