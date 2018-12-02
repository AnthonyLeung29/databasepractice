package com.app.gui.menu.frames;

import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ATextField extends JTextField {

	public ATextField() {
		super(20);
	}
	
	public ATextField(String initial) {
		super(initial);
	}
	
	public int getPositiveInt() {
		try {
			return Integer.parseInt(super.getText());
		} catch (NumberFormatException e) {
			System.out.println("Unable to parse int");
			return -1;
		}
	}
	
	public String[] getParsedText(String delimiter, int minElements) {
		String[] texts = super.getText().trim().split(delimiter);
		if (texts.length < minElements) {
			return null;
		} 
		return texts;
	}
}
