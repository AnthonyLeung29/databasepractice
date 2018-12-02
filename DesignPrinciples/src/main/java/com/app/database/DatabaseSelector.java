package com.app.database;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DatabaseSelector extends DatabaseExecuteUpdate {

	public static ResultSet select(String tableName, List<String> wantedCols, List<String> where, List<Object> values) {
		System.out.println("Selecting from the database...");
		
		String sql = getFormattedSelectSQL(tableName, wantedCols, where);
		ResultSet results = executeSelectSQL(sql, values);
		
		if (results != null) {
			System.out.println("Successfully selected from the database");
		} else
			System.out.println("Was unable to insert into the database");
		
		return results;
	}
	
	// temporary for inserts. Where clasuses will be much more complicated
	private static String getFormattedSelectSQL(String tableName, List<String> wantedCols, List<String> where) {
		List<String> emptyWhere = new ArrayList<String>();
		
		// Comma separated attributes and values
		String formattedWantedCols = String.join(", ", wantedCols);
		String formattedEmptyValues = " WHERE ";
		
		for (int i = 0; i < where.size(); i++) {
			emptyWhere.add(where.get(i) + " = ?");
		}
		
		return "SELECT " + formattedWantedCols + " FROM " + tableName + " WHERE " + String.join(" AND ", emptyWhere);
	}
}
