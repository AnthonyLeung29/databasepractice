package com.app.database;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DatabaseInserter {

	public static int insertBook(String isbn, String title, String publisher, int numOfPages, int yearOfPublication) {
		Connection con = DatabaseDriver.getConnection();
		
		String sql = "INSERT INTO book(isbn, title, publisher, numberofpages, yearofpublication) VALUES (?,?,?,?,?)";
		
		  try {
			  PreparedStatement preparedStatement = con.prepareStatement(sql);
			  preparedStatement.setString(1, isbn);
			  preparedStatement.setString(2, title);
			  preparedStatement.setString(3, publisher);
			  preparedStatement.setInt(4, numOfPages);
			  preparedStatement.setInt(5, yearOfPublication);
			  preparedStatement.executeUpdate();
			  return 0;
		  } catch (Exception e) {
			  e.printStackTrace();
		  }
		return -1;
		
	}
}
