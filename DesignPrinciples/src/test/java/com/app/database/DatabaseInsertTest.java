package com.app.database;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DatabaseInsertTest {

	@Test
	@DisplayName("Inserting a book")
	public void testInsertOneUser() {
		Connection con = DatabaseDriver.getConnection();
		
		String sql = "INSERT INTO book(isbn, title, publisher, numberofpages, yearofpublication";
	}

}
