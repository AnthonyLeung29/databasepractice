package com.app.gui.menu.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class ViewMenu extends JMenu implements ActionListener {

	public ViewMenu() {
		super("View");
		this.initialize();
	}
	
	private void initialize() {
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
