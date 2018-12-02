package com.app.gui.menu.frames;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;

import javax.swing.JPanel;

import com.app.gui.bases.FieldsBase;
import com.app.helpers.GuiHelper;

/**
 * Creates a fields frame with the labels on the left side
 * and the text fields on the right side
 * 
 * @author antho
 *
 */
@SuppressWarnings("serial")
public abstract class VerticalFieldsFrame extends FieldsBase {

	/**
	 * Interface to dictate subclasses and how they will create fields
	 * 
	 * @author antho
	 *
	 */
	public interface ProductFields {

		public String getDisplayName();
		
		// Unused atm
		public static <E extends Enum<E>> List<String> getDisplayNames(Class<E> dbAttributes) {
			List<String> names = new ArrayList<String>();
			for (E dataEnum : EnumSet.allOf(dbAttributes)) {
				names.add(dataEnum.name());
			}
			
			return names;
		}
	}
	
	private ProductFields[] fieldNames;
	
	protected HashMap<ProductFields, ATextField> dataFields;
	
	public VerticalFieldsFrame(String title, ProductFields[] fields) {
		super(title);
		this.fieldNames = fields;
		this.dataFields = new HashMap<ProductFields, ATextField>();
		super.setBody(getFieldsPanel());
	}

	@Override
	protected JPanel getFieldsPanel() {
		List<String> labels = new ArrayList<String>();
		for (ProductFields col : fieldNames) {
			labels.add(col.getDisplayName());
		}
		
		List<ATextField> textFields = GuiHelper.createTextFields(labels.size());
		for (int i = 0; i < labels.size(); i ++) {
			dataFields.put(fieldNames[i], textFields.get(i));
		}
		
		JPanel p = GuiHelper.createLabelPanel(labels, textFields);
		return p;
	}
}
