package com.app.gui.menu.frames;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextField;

import com.app.gui.bases.FieldsBase;
import com.app.gui.menu.frames.fields.ProductFields;
import com.app.helpers.JGuiHelper;

/**
 * Creates a fields frame with the labels on the left side
 * and the text fields on the right side
 * 
 * @author antho
 *
 */
@SuppressWarnings("serial")
public class VerticalFieldsFrame extends FieldsBase {

	private String tableName;
	private ProductFields[] columns;
	private HashMap<ProductFields, JTextField> dataFields;
	
	public VerticalFieldsFrame(String tableName, ProductFields[] colFields) {
		super(tableName);
		this.tableName = tableName;
		this.columns = colFields;
		this.dataFields = new HashMap<ProductFields, JTextField>();
		super.setBody(getFieldsPanel());
	}

	@Override
	protected JPanel getFieldsPanel() {
		List<String> labels = new ArrayList<String>();
		for (ProductFields col : columns) {
			labels.add(col.getDisplayName());
		}
		
		List<JTextField> textFields = JGuiHelper.createTextFields(labels.size());
		for (int i = 0; i < labels.size(); i ++) {
			dataFields.put(columns[i], textFields.get(i));
		}
		
		JPanel p = JGuiHelper.createLabelPanel(labels, textFields);
		return p;
	}

	@Override
	protected boolean submitAction() {
		// TODO Insert all the fields from the hashmap into the database
		tableName.length();
		return false;
	}
}
