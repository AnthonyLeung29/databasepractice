package com.app.gui.menu.frames;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextField;

import com.app.bases.FieldsBase;
import com.app.bases.Product;
import com.app.helpers.JGuiHelper;
import com.app.product.Book;
import com.app.product.BookCol;
import com.app.product.DbCol;

@SuppressWarnings("serial")
public class BookFieldsFrame extends FieldsBase {
	
	HashMap<DbCol, JTextField> dataFields;
	
	public BookFieldsFrame() {
		super("Book fields");
	}

	@Override
	protected JPanel getFieldsPanel() {
		List<String> labels = BookCol.getDisplayNames();
		List<JTextField> textFields = JGuiHelper.createTextFields(labels.size());
		// HashMap<DatabaseData, JTextField> dataFields = JGuiHelper.createTextFields(BookData.values());
		
		dataFields = new HashMap<DbCol, JTextField>();
		
		for (int i = 0; i < labels.size(); i ++) {
			dataFields.put(BookCol.values()[i], textFields.get(i));
		}
		
		JPanel p = JGuiHelper.createLabelPanel(labels, textFields);
		
		return p;
	}

	@Override
	protected boolean submitAction() {
		// TODO: Insert into the database
		return false;
	}

}
