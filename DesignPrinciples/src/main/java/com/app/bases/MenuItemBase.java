package com.app.bases;

import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

/**
 * An abstract class that mandates all menu items.
 * This is for use to automatically add an action listener to all menu items
 * 
 * @author antho
 *
 */
@SuppressWarnings("serial")
public abstract class MenuItemBase extends JMenuItem implements ActionListener {

	public MenuItemBase(String itemName) {
		super(itemName);
		super.addActionListener(this);
	}
}
