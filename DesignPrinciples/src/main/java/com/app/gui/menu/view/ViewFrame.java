package com.app.gui.menu.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.app.bases.FieldsBase;
import com.app.helpers.JGuiHelper;
import com.app.product.ProductCol;

@SuppressWarnings("serial")
public class ViewFrame extends FieldsBase {

	private static final String TITLE = "View";
	private JTextField name, year; // These should be fields in all of the db cols
	private HashMap<ProductCol, JCheckBox> checkboxes;
	
	public ViewFrame() {
		super(TITLE);
		
		// This way of initialization could be improved via hashmap
		// Like I did with vertical fields frame
		name = new JTextField(20);
		year = new JTextField(20);
		
		checkboxes = new HashMap<ProductCol, JCheckBox>();
		
		super.setBody(getFieldsPanel());
	}

	@Override
	protected JPanel getFieldsPanel() {
		JPanel parent, leftp, rightp;
		
		parent = new JPanel();
		parent.setLayout(new BoxLayout(parent, BoxLayout.X_AXIS));
		
		leftp = createLeftPanel();
		parent.add(leftp);
		
		List<String> rightLbls = Arrays.asList("Name of the product: ", "Year of Release/Publication: ");
		rightp = JGuiHelper.createLabelPanel(rightLbls, Arrays.asList(name, year));
		parent.add(rightp);
		
		return parent;
	}

	@Override
	protected boolean submitAction() {
		// TODO Query the database
		return false;
	}
	
	private JPanel createLeftPanel() {
		JPanel p = JGuiHelper.createPanelBox(BoxLayout.Y_AXIS);
		ProductCol[] products = ProductCol.values();
		List<String> lbls = new ArrayList<String>();
		
		for (int i = 0; i < products.length; i++) {
			lbls.add(products[i].getDisplayName());
		}
		
		List<JCheckBox> chkBoxes = JGuiHelper.createCheckBoxes(lbls);
		for (int i = 0; i < lbls.size(); i++) {
			p.add(chkBoxes.get(i));
			checkboxes.put(products[i], chkBoxes.get(i));
		}
		
		return p;
	}

}
