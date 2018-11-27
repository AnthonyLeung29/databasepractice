package com.app.gui.menu.frames;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextField;

import com.app.bases.FieldsBase;
import com.app.helpers.JGuiHelper;
import com.app.product.DbCol;

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
	private DbCol[] columns;
	private HashMap<DbCol, JTextField> dataFields;
	
	public VerticalFieldsFrame(String tableName, DbCol[] colFields) {
		super(tableName);
		this.tableName = tableName;
		this.columns = colFields;
		this.dataFields = new HashMap<DbCol, JTextField>();
		super.setBody(getFieldsPanel());
	}

	@Override
	protected JPanel getFieldsPanel() {
		List<String> labels = new ArrayList<String>();
		for (DbCol col : columns) {
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
