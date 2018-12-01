package com.app;

import java.sql.Connection;

import com.app.database.DatabaseDriver;
import com.app.database.DatabaseInserter;
import com.app.gui.MainMenuSQL;

public class DatabaseMain {
	
	public static void main(String[] args) {
/*		MainMenuSQL main = new MainMenuSQL("None atm");
		main.start();
		*/
		Connection con = DatabaseDriver.getConnection();
		String sql = "INSERT INTO book(isbn, title, publisher, numberofpages, yearofpublication";
		
		DatabaseInserter.insertBook("102039310", "Random title", "anthony", 4, 2018);
		
		
	}
}
