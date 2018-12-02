package com.app.gui.menu.frames;

import java.util.Arrays;
import java.util.List;

import com.app.database.helper.DatabaseInsertHelper;
import com.app.database.tables.Table;

@SuppressWarnings("serial")
public class BookFieldsFrame extends VerticalFieldsFrame {

	public enum BookFields implements ProductFields {
		NAME("Name of Book"),
		YEAR("Year Of Publication"),
		ISBN("ISBN Number"),
		PUBLISHER("Publisher Name"),
		NUMBER_OF_PAGES("Number of Pages"),
		DESCRIPTION("Description"),
		EDITION_NUMBER("Edition Number"),
		AUTHOR1("Author 1 (Surname, first, middle)"),
		AUTHOR2("Author 2 (Surname, first, middle)"),
		AUTHOR3("Author 3 (Surname, first, middle)"),
		AUTHOR4("Author 4 (Surname, first, middle)"),
		AUTHOR5("Author 5 (Surname, first, middle)");

		private String displayName;

		private BookFields(String displayName) {
			this.displayName = displayName;
		}

		public String getDisplayName() {
			return this.displayName;
		}
	}

	private final static int MIN_ELEMENTS = 2;

	public BookFieldsFrame() {
		super(Table.BOOK + " Fields", BookFields.class.getEnumConstants());
	}

	@Override
	protected boolean submitAction() {
		String isbn = dataFields.get(BookFields.ISBN).getText();
		String title = dataFields.get(BookFields.YEAR).getText();
		String publisher = dataFields.get(BookFields.PUBLISHER).getText();
		int numPages = dataFields.get(BookFields.NUMBER_OF_PAGES).getPositiveInt();
		int year = dataFields.get(BookFields.YEAR).getPositiveInt();
		int editionNum = dataFields.get(BookFields.EDITION_NUMBER).getPositiveInt();
		String description = dataFields.get(BookFields.DESCRIPTION).getText();

		String[] author1 = dataFields.get(BookFields.AUTHOR1).getParsedText(",", MIN_ELEMENTS);
		String[] author2 = dataFields.get(BookFields.AUTHOR2).getParsedText(",", MIN_ELEMENTS);
		String[] author3 = dataFields.get(BookFields.AUTHOR3).getParsedText(",", MIN_ELEMENTS);
		String[] author4 = dataFields.get(BookFields.AUTHOR4).getParsedText(",", MIN_ELEMENTS);
		String[] author5 = dataFields.get(BookFields.AUTHOR5).getParsedText(",", MIN_ELEMENTS);

		List<String[]> authors = Arrays.asList(author1, author2, author3, author4, author5);

		int insertBook = -1;
		int insertAuthor = -1;
		if (isAuthorsValid(authors)) {
			insertBook = insertBook(isbn, title, publisher, numPages, year, editionNum, description);
			insertAuthor = insertAuthors(isbn, authors);
		}

		boolean isSuccess = (insertBook > -1 && insertAuthor > -1) ? true : false;
		return isSuccess;
	}

	private int insertBook(String isbn, String title, String publisher, int numPages, int year, int editionNum, String description) {
		int result = -1;

		if (editionNum < 0 && description != "") {
			result = DatabaseInsertHelper.insertBook(isbn, title, publisher, numPages, year, description);
		} else if (editionNum >= 0 && description == "") {
			result = DatabaseInsertHelper.insertBook(isbn, title, publisher, numPages, year, editionNum);
		} else {
			result = DatabaseInsertHelper.insertBook(isbn, title, publisher, numPages, year, editionNum, description);
		}
		
		return result;
	}

	private int insertAuthors(String isbn, List<String[]> authors) {
		int result = -1;

		for (String[] author : authors) {
			if (author != null) {
				String firstName = author[1];
				String lastName = author[0];
				if (author.length == 2) {
					result = DatabaseInsertHelper.insertBookAuthor(isbn, firstName, lastName);
				} else if (author.length == 3) {
					String middleName = author[2];
					result = DatabaseInsertHelper.insertBookAuthor(isbn, firstName, lastName, middleName);
				}
			}
		}

		return result;
	}

	private boolean isAuthorsValid(List<String[]> authors) {
		boolean isValid = false;

		for (String[] author : authors) {
			if (author != null)
				isValid = true;
		}

		return isValid;
	}
}
