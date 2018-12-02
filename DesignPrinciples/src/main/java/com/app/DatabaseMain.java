package com.app;

import java.sql.Connection;
import java.util.Arrays;

import com.app.database.DatabaseDriver;
import com.app.database.DatabaseInserter;
import com.app.database.helper.DatabaseInsertHelper;
import com.app.database.helper.DatabaseSelectHelper;
import com.app.database.DatabaseExecuteUpdate;
import com.app.gui.MainMenuSQL;

public class DatabaseMain {
	
	public static void main(String[] args) {
		MainMenuSQL main = new MainMenuSQL("None atm");
		main.start();
		

/*		DatabaseInserter.insert(Table.BOOK, Arrays.asList("isbn", "title", "publisher", "numberofpages", "yearofpublication"),
				Arrays.asList("102059313", "Random title", "anthony", 5, Integer.valueOf(2018)));*/
		
		// DatabaseInsertHelper.insertBook("102059313", "Random title", "anthony", 5, 2018);
		// DatabaseInsertHelper.insertPeopleInvolved("Anthony", "Leung");
		// System.out.println(DatabaseInsertHelper.insertBookKeyword("102059313", "funny"));
	}
}
