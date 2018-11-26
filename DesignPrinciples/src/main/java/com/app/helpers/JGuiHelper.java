package com.app.helpers;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JGuiHelper {

	public static JButton createButton(String name, ActionListener listener, String actionCommand) {
		JButton btn = new JButton(name);
		btn.addActionListener(listener);
		btn.setActionCommand(actionCommand);
		return btn;
	}

	public static List<JTextField> createTextFields(int number) {
		List<JTextField> fields = new ArrayList<JTextField>();

		for (int i = 0; i < number; i++) {
			fields.add(new JTextField(20));
		}

		return fields;
	}

	/**
	 * Creates a (n by 2) grid layout where the left side is the labels and the
	 * right side is the fields. N is the number of fields. The number of labels
	 * must equal to the number of textfields.
	 * 
	 * @param labelText
	 * @param textfields
	 * @return
	 */
	public static JPanel createLabelPanel(List<String> labels, List<JTextField> textFields) {
		int size;
		if (labels.size() == textFields.size()) {
			size = labels.size();
		} else {
			return null;
		}

		JPanel p = new JPanel();
		p.setLayout(new GridLayout(size, 2));

		for (int i = 0; i < size; i++) {
			p.add(new JLabel(labels.get(i)));
			p.add(textFields.get(i));
		}

		return p;
	}

	
	// These under not used atm
	/**
	 * Creates a panel with the preset layout for BoxLayout
	 * 
	 * Can be one of: BoxLayout.X_AXIS, BoxLayout.Y_AXIS, BoxLayout.LINE_AXIS
	 * BoxLayout.PAGE_AXIS
	 * 
	 * @param layout_axis
	 * @return
	 */

	public static JPanel createPanelBox(int layout_axis) {
		JPanel p = new JPanel();
		BoxLayout pLayout = new BoxLayout(p, layout_axis);
		p.setLayout(pLayout);
		p.setAlignmentX(Component.LEFT_ALIGNMENT);
		return p;
	}

	/**
	 * Creates a panel with a preset layout for FLowLayout aligned to the left
	 * 
	 * @return
	 */
	public static JPanel createPanelFlow() {
		JPanel p = new JPanel(new FlowLayout());
		p.setAlignmentX(Component.LEFT_ALIGNMENT);
		return p;
	}

}
