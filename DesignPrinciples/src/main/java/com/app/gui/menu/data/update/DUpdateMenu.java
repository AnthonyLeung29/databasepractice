package com.app.gui.menu.data.update;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import com.app.gui.menu.frames.VerticalFieldsFrame;

@SuppressWarnings("serial")
public class DUpdateMenu extends JMenuItem implements ActionListener {

	private static final String DISPLAY_NAME = "Update";
	
	public DUpdateMenu() {
		super(DISPLAY_NAME);
		super.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
        String name = (String)JOptionPane.showInputDialog(
                getParent(),
                "What's the product you're looking for? \n "
                + "(A book, album, or movie)",
                "Searching for...",
                JOptionPane.PLAIN_MESSAGE);
        // Check what happens if cancel is selected
        // TODO: Find which table it's in via DB helper
        // VerticalFieldsFrame frame = new VerticalFieldsFrame(null, null);
        // get the attributes from table
        // ResultSet result;
        
	}
}
