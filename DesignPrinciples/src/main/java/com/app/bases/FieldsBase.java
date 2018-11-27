package com.app.bases;

import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.app.helpers.JGuiHelper;

/**
 * The base to create the frame with the body (the children) with a submit and cancel
 * button below it. <br>
 * On a successful submit, a display message will pop up indicating that the request
 * has been successful
 * 
 * @author antho
 *
 */
@SuppressWarnings("serial")
public abstract class FieldsBase extends FrameBase implements ActionListener {

	private static final String SUCCESS_MSG = "Your request has been successful!";
	private static final String FAIL_MSG = "Something has went wrong, please check your fields again";
	
	private class ActionConsts {
		private static final String SUBMIT = "submit";
		private static final String CANCEL = "cancel";
	}
	
	private JPanel fieldPanel;
	private LayoutManager layout;
	
	public FieldsBase(String title) {
		super(title);
		layout = new BoxLayout(getContentPane(), BoxLayout.Y_AXIS);
		fieldPanel = new JPanel();
		
		super.setLayout(layout);
		super.add(fieldPanel);
		super.add(getButtonPanel());
	}
	
	protected abstract JPanel getFieldsPanel();
	
	/**
	 * A method that all children must have to dictate what the
	 * submit button will do for this frame.
	 * 
	 * @return a boolean indication if the action succeeded
	 */
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
	
	public void setBody(JPanel newBody) {
		this.fieldPanel.removeAll();
		this.fieldPanel.add(newBody);
		super.update();
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
