package com.app.gui.menu.data.remove;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class DRemoveMenuItem extends JMenuItem implements ActionListener {

	private static final String DISPLAY_NAME = "Remove";
	
	public DRemoveMenuItem() {
		super(DISPLAY_NAME);
		super.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
        String name = (String)JOptionPane.showInputDialog(
                getParent(),
                "What's the product you're looking to remove? \n "
                + "(A book, album, or movie)",
                "Removing Entry",
                JOptionPane.PLAIN_MESSAGE);
        // Check what happens if cancel is selected
        // TODO: Find which table it's in via DB helper
        // Delete the entry from everywhere
	}

}
