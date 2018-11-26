package com.app.product;

import java.util.Arrays;
import java.util.List;

import com.app.bases.Product;
import com.app.bases.ProductBase;
import com.app.person.Author;

/**
 * BookData enum needs to be updated if this has new parameters. A design pattern might be useful?
 * TODO: Find one potentially
 * 
 * @author antho
 *
 */
public class Book extends ProductBase implements Product {
	
	// Required parameters
	private long isbn; // 13 digit number
	private String publisherName;
	private List<Author> authors; // At least 1, at most 5
	private int numberOfPages;
	
	// Optional Parameters
	private List<String> keywords; // At most 20 keywords at once
	private String description;
	private int editionNumber;

	public Book() {
		this(null, 0, 0, null, null, 0);
	}
	
	public Book(String name, int year, long isbn, String publisherName, List<Author> authors, int numberOfPages) {
		super(name, year);
		this.isbn = isbn;
		this.publisherName = publisherName;
		this.authors = authors;
		this.numberOfPages = numberOfPages;
	}

	@Override
	protected List<Object> getRestOfAttributeValues() {
		return Arrays.asList(isbn, publisherName, authors, numberOfPages, keywords, description, editionNumber);
	}
	
	public long getISBN() {
		return this.isbn;
	}
	
	public String getPublisherName() {
		return this.publisherName;
	}
	
	public List<Author> getAuthors() {
		return this.authors;
	}
	
	public int getNumberOfPages() {
		return this.numberOfPages;
	}
	
	public List<String> getKeywords() {
		return this.keywords;
	}
	
	public String getDescription() {
		return this.getDescription();
	}

	public int getEditionNumber() {
		return this.editionNumber;
	}
	
	public void setISBN(long isbn) {
		this.isbn = isbn;
	}
	
	public void setPublisherName(String name) {
		this.publisherName = name;
	}
	
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	
	public void setNumberOfPages(int pages) {
		this.numberOfPages = pages;
	}
	
	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	public void setEditionNumber(int number) {
		this.editionNumber = number;
	}
}
