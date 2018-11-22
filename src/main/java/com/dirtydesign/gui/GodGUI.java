package com.dirtydesign.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;

/**
 * Fun thing, trying to do this with just functions! No classes except for the
 * one everything is in and the action consts just for readability and action
 * listeners cus it's needed. Basically as bare as it can be
 * 
 * @author antho
 *
 */
@SuppressWarnings("serial")
public class GodGUI extends JFrame implements ActionListener {

	public static void main(String[] args) {
		frame.initialize();
	}

	public class ActionConsts {
		public static final String INSERT_BOOK = "i_book";
		public static final String INSERT_MUSIC = "i_music";
		public static final String INSERT_MOVIE = "i_movie";
		public static final String UPDATE = "Update";
		public static final String VIEW = "view";
		public static final String REMOVE = "remove";
	}

	public static class Actions {
		public static final ActionListener BOOK_SUBMIT = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Insert the values into the database
			}
		};

		public static final ActionListener MUSIC_SUBMIT = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Insert the values into the database
			}
		};

		public static final ActionListener MOVIE_SUBMIT = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Insert the values into the database
			}
		};

		private static final ActionListener CANCEL = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GodGUI.restart();
			}
		};
	}

	// Common to all 3
	JTextField productName = new JTextField(20);
	JTextField yearOfReleaseOrPublication = new JTextField(20);

	// Book fields
	JTextField isbn = new JTextField(20);
	JTextField publisherName = new JTextField(20);
	JTextField editionNumber = new JTextField(20);
	JTextField author1 = new JTextField(20);
	JTextField author2 = new JTextField(20);
	JTextField author3 = new JTextField(20);
	JTextField author4 = new JTextField(20);
	JTextField author5 = new JTextField(20);
	JTextField keywords = new JTextField(20);
	JTextField description = new JTextField(20);

	// Music Album fields
	JTextField trackName = new JTextField(20); // Can have more than one track
	JTextField language = new JTextField(20);
	JTextField singers = new JTextField(20);
	JTextField songWriter = new JTextField(20);
	JTextField composer = new JTextField(20);
	JTextField producers = new JTextField(20);
	JTextField arrangement = new JTextField(20);

	// Movie fields
	JTextField directors = new JTextField(20);
	JTextField scriptWriters = new JTextField(20);
	JTextField casts = new JTextField(20);
	JTextField composers = new JTextField(20);
	JTextField editors = new JTextField(20);
	JTextField costumeDesigners = new JTextField(20);

	private static GodGUI frame = new GodGUI();

	private GodGUI() {
		super();
		BoxLayout layout = new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS);
		setLayout(layout);
		setMinimumSize(new Dimension(800, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void initialize() {
		JMenu menu;
		JMenu subMenu;
		JMenuItem menuItem;

		// Create the menu bar menus
		JMenuBar menuBar = new JMenuBar();

		// Create the menu items for data
		menu = new JMenu("Data");

		subMenu = new JMenu("Insert");
		subMenu.add(createJMenuItem("Book", ActionConsts.INSERT_BOOK));
		subMenu.add(createJMenuItem("Music", ActionConsts.INSERT_MUSIC));
		subMenu.add(createJMenuItem("Movie", ActionConsts.INSERT_MOVIE));
		menu.add(subMenu);

		menu.add(createJMenuItem("Update", ActionConsts.UPDATE));
		// TODO: Show dialog box that asks for name. If ok is selected, then show all
		// information about the product
		// User should be able to edit the fields and submit to save or cancel

		menuItem = new JMenuItem("Remove");
		menu.add(menuItem);
		// Same thing for the remove

		menuBar.add(menu);

		JMenu viewMenu = new JMenu("View");
		JMenu reportMenu = new JMenu("Report");

		// Show the frame
		setJMenuBar(menuBar);
		pack();
	}

	public void changeBodyToBookFields() {
		restart();
		add(createLabelWithField("Name of Book: ", productName));
		add(createLabelWithField("ISBN: ", isbn));
		add(createLabelWithField("Name of Publisher: ", publisherName));
		add(createLabelWithField("Edition Number: ", editionNumber));
		add(createLabelWithField("Author 1: (Surname, first, middle separated by commas)", author1));
		add(createLabelWithField("Author 2: (Surname, first, middle separated by commas)", author2));
		add(createLabelWithField("Author 3: (Surname, first, middle separated by commas)", author3));
		add(createLabelWithField("Author 4: (Surname, first, middle separated by commas)", author4));
		add(createLabelWithField("Author 5: (Surname, first, middle separated by commas)", author5));
		add(createLabelWithField("Publication Year: ", yearOfReleaseOrPublication));
		add(createLabelWithField("Keywords: (Also separated by commas)", keywords));
		add(createLabelWithField("Description: ", description));

		add(createButtonPane(Actions.BOOK_SUBMIT));
		pack();
	}

	public void changeBodyToMusicFields() {
		restart();
		add(createLabelWithField("Name of Album: ", productName));
		add(createLabelWithField("Year Published: ", publisherName));

		add(createLabelWithField("Name of Track: ", trackName));
		add(createLabelWithField("Language of Track:", language));
		add(createLabelWithField("Singers: (Separated by commas)", singers));
		add(createLabelWithField("Song Writer: ", songWriter));
		add(createLabelWithField("Composer: ", composer));
		add(createLabelWithField("Producer: ", producers));
		add(createLabelWithField("Arrangement: ", arrangement));

		add(createButtonPane(Actions.MUSIC_SUBMIT));
		pack();
	}

	public void changeBodyToMovieFields() {
		restart();
		add(createLabelWithField("Name of Movie: ", productName));
		add(createLabelWithField("Name of Directors: (Separated by commas)", directors));
		add(createLabelWithField("Name of Script Writers: (Separated by commas) ", scriptWriters));
		add(createLabelWithField("Name of Casts: (Separated by commas)", casts));
		add(createLabelWithField("Name of Producers: (Separated by commas)", producers));
		add(createLabelWithField("Name of Composers: (Separated by commas)", composers));
		add(createLabelWithField("Name of Editors: (Separated by commas)", editors));
		add(createLabelWithField("Name of Costume Designers: (Separated by commas)", costumeDesigners));
		add(createLabelWithField("Year of Release: ", yearOfReleaseOrPublication));

		add(createButtonPane(Actions.MOVIE_SUBMIT));
		pack();
	}
	
	public void setTextValues(String[] values) {
		JTextField[] book = {productName, isbn, publisherName, editionNumber, 
				author1, author2, author3, author4, author5,
				yearOfReleaseOrPublication, keywords, description};
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();

		switch (cmd) {
			case ActionConsts.INSERT_BOOK:
				frame.changeBodyToBookFields();
				break;
			case ActionConsts.INSERT_MUSIC:
				frame.changeBodyToMusicFields();
				break;
			case ActionConsts.INSERT_MOVIE:
				frame.changeBodyToMovieFields();
				break;
			case ActionConsts.UPDATE:
				String s = (String) JOptionPane.showInputDialog(frame.getContentPane(),
						"What's the name of your product?");
				// TODO: Code to retrieve from DB
				// Then change the body to whatever type was found
				// frame.setTextValues(
			case ActionConsts.VIEW:
				break;
			case ActionConsts.REMOVE:
				break;
		}
	}

	@Override
	public void pack() {
		super.pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private JMenuItem createJMenuItem(String name, String action) {
		JMenuItem menuItem = new JMenuItem(name);
		menuItem.addActionListener(frame);
		menuItem.setActionCommand(action);
		return menuItem;
	}

	private JComponent createButtonPane(ActionListener action) {
		JPanel p = new JPanel();
		JButton submitBtn = new JButton("Submit");
		JButton cancelBtn = new JButton("Cancel");
		submitBtn.addActionListener(action);
		cancelBtn.addActionListener(Actions.CANCEL);

		p.add(submitBtn);
		p.add(cancelBtn);

		return p;
	}

	private JComponent createLabelWithField(String labelText, JTextField textfield) {
		JPanel p = new JPanel(new FlowLayout());
		JLabel userlbl = new JLabel(labelText);

		p.add(userlbl);
		p.add(textfield);

		return p;
	}

	private static void restart() {
		frame.setVisible(false);
		frame.dispose();
		frame = new GodGUI();
		frame.initialize();
	}
}
