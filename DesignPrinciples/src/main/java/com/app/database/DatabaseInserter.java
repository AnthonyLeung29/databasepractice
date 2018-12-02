package com.app.database;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Inserts the data into the given attributes on the given table. No error checking is done.
 * 
 * @author antho
 *
 */
public class DatabaseInserter extends DatabaseExecuteUpdate {
	
	public static int insert(String tableName, List<String> attributes, List<Object> data) {
		System.out.println("Inserting into the database...");
		
		String sql = getFormattedInsertSQL(tableName, attributes);
		int rowsChanged = executeSQL(sql, data);
		
		if (rowsChanged >= 0) 
			System.out.println("Successfully inserted into the database");
		else
			System.out.println("Was unable to insert into the database");
		
		return rowsChanged;
	}
	
	/**
	 * Prepares a query of the form "INSERT INTO user_password(userID, password) VALUES(?,?)"
	 * given the table and list of attributes to insert into
	 * 
	 * @param table
	 * @param attributes
	 * @return
	 */
	private static String getFormattedInsertSQL(String tableName, List<String> attributes) {
		// String of size n consisting of (?, ?, ?,...)
		List<String> emptyValues = new ArrayList<String>(Collections.nCopies(attributes.size(), "?"));
		
		// Comma separated attributes and values
		String formattedAttributes = "(" + String.join(", ", attributes) + ")";
		String formattedEmptyValues = "(" + String.join(", ", emptyValues) + ")";
		
		return "INSERT INTO " + tableName + formattedAttributes + " VALUES " + formattedEmptyValues;
	}
}
