package com.app.helpers;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public class JGuiHelper {

	public static JButton createButton(String name, ActionListener listener, String actionCommand) {
		JButton btn = new JButton(name);
		btn.addActionListener(listener);
		btn.setActionCommand(actionCommand);
		return btn;
	}
}
