package com.app.bases;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.app.helpers.JGuiHelper;

@SuppressWarnings("serial")
public abstract class FieldsBase extends FrameBase implements ActionListener {

	private static final String SUCCESS_MSG = "Your request has been successful!";
	private static final String FAIL_MSG = "Something has went wrong, please check your fields again";
	
	private class ActionConsts {
		private static final String SUBMIT = "submit";
		private static final String CANCEL = "cancel";
	}
	
	public FieldsBase(String title) {
		super(title);
		super.add(getBodyPanel());
		super.add(getButtonPanel());
	}
	
	protected abstract JPanel getBodyPanel();
	
	protected abstract boolean submitAction();

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		if (cmd.equals(ActionConsts.SUBMIT)) {
			displaySubmittedDialog(submitAction());
		} else if (cmd.equals(ActionConsts.CANCEL)) {
			super.close();
		}
	}
	
	protected void displaySubmittedDialog(boolean isSuccess) {
		if (isSuccess) {
			JOptionPane.showMessageDialog(getContentPane(), SUCCESS_MSG);
		} else {
			JOptionPane.showMessageDialog(getContentPane(), FAIL_MSG, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private JPanel getButtonPanel() {
		JPanel p = new JPanel();
		JButton submitBtn = JGuiHelper.createButton("Submit", this, ActionConsts.SUBMIT);
		JButton cancelBtn = JGuiHelper.createButton("Cancel", this, ActionConsts.CANCEL);

		p.add(submitBtn);
		p.add(cancelBtn);

		return p;
	}
}
