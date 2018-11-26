package com.app.gui.menu.data.insert;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import com.app.bases.Product;
import com.app.gui.menu.frames.VerticalFieldsFrame;
import com.app.product.ProductCol;

@SuppressWarnings("serial")
public class DInsertMenuItem extends JMenuItem implements ActionListener {

	private ProductCol product;
	
	public DInsertMenuItem(ProductCol product) {
		super(product.name());
		this.product = product;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// VerticalFieldsFrame frame = new VerticalFieldsFrame(product.name() + " Fields", product.getEnum().getEnumConstants());
		
	}

}
