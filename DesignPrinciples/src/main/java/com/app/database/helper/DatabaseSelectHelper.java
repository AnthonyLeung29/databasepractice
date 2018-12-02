package com.app.database.helper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import com.app.database.DatabaseSelector;
import com.app.database.tables.Table;
import com.app.database.tables.TableAttributes.KeywordAttributes;
import com.app.database.tables.TableAttributes.PeopleInvolvedAttributes;

public class DatabaseSelectHelper {

	public static int getPersonInvolvedId(String firstName, String lastName) {
		List<String> wantedCols = Arrays.asList(PeopleInvolvedAttributes.ID);
		
		List<String> attributes = Arrays.asList(
				PeopleInvolvedAttributes.FIRST_NAME,
				PeopleInvolvedAttributes.FAMILY_NAME);
		List<Object> data = Arrays.asList(firstName, lastName);
		
		int id = -1;
		
		ResultSet results = DatabaseSelector.select(Table.PEOPLE_INVOLVED, wantedCols, attributes, data);
		try {
			
			if (results != null) {
				if (results.next())
					id = results.getInt(PeopleInvolvedAttributes.ID);
				results.close();
			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
	}
	
	public static int getKeywordId(String keyword) {
		List<String> wantedCols = Arrays.asList(KeywordAttributes.ID);
		
		List<String> attributes = Arrays.asList(KeywordAttributes.TAG);
		List<Object> data = Arrays.asList(keyword);
		
		int id = -1;
		
		ResultSet results = DatabaseSelector.select(Table.KEYWORD, wantedCols, attributes, data);
		try {
			
			if (results != null) {
				if (results.next())
					id = results.getInt(KeywordAttributes.ID);
				results.close();
			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
	}
}
