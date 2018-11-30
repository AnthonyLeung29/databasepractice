package com.app.gui.bases;

import javax.swing.JMenu;

/**
 * An abstract class that mandates all new menus.
 * This forces each new menu made to have a method to add menus as a design of the code
 * 
 * @author antho
 *
 */
@SuppressWarnings("serial")
public abstract class MenuBase extends JMenu {

	/**
	 * An initiation method that all menus will have. 
	 * Will mainly consist of adding sub menus or items with the super.add(item)
	 */
	protected abstract void addItems();
	
	public MenuBase(String menuName) {
		super(menuName);
		this.addItems();
	}
}
