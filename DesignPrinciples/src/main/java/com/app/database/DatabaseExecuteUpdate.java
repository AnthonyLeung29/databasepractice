package com.app.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Abstract class to mandate the PreparedStatements for DML. <br>
 * Executes the SQL statement in this PreparedStatement object,which must be an
 * SQL Data Manipulation Language (DML) statement, such as INSERT, UPDATE or
 * DELETE; or an SQL statement that returns nothing,such as a DDL statement.
 * 
 * @author antho
 *
 */
public abstract class DatabaseExecuteUpdate {

	/**
	 * Executes the following sql with the given data and returns the number of rows
	 * affected.
	 * 
	 * @param sql
	 * @param data
	 * @return either (1) the row count for SQL Data Manipulation Language (DML)
	 *         statements or (2) 0 for SQL statements that return nothing.
	 */
	protected static int executeSQL(String sql, List<Object> data) {
		int rowsChanged = -1;
		Connection connection = DatabaseDriver.getConnection();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			// Index for columns for MYSQL starts at 1
			for (int i = 0; i < data.size(); i++) {
				setStatement(preparedStatement, i + 1, data.get(i));
			}

			rowsChanged = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error has occured trying to execute a DML statement");
			e.printStackTrace();
		}

		// connection.close();
		return rowsChanged;
	}

	protected static ResultSet executeSelectSQL(String sql, List<Object> values) {
		ResultSet results = null;
		Connection connection = DatabaseDriver.getConnection();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			// Index for columns for MYSQL starts at 1
			for (int i = 0; i < values.size(); i++) {
				setStatement(preparedStatement, i + 1, values.get(i));
			}

			results = preparedStatement.executeQuery();
		} catch (SQLException e) {
			System.out.println("Error has occured trying to execute a SELECT statement");
			e.printStackTrace();
		}

		// connection.close();
		return results;
	}

	protected static ResultSet executeSelectSQL(String sql) {
		ResultSet results = null;
		Connection connection = DatabaseDriver.getConnection();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			results = preparedStatement.executeQuery();
		} catch (SQLException e) {
			System.out.println("Error has occured trying to execute a SELECT statement");
			e.printStackTrace();
		}

		// connection.close();
		return results;
	}

	private static void setStatement(PreparedStatement preparedStatement, int parameterIndex, Object data)
			throws SQLException {
		if (data instanceof String) {
			preparedStatement.setString(parameterIndex, (String) data);
		} else if (data instanceof Integer) {
			preparedStatement.setInt(parameterIndex, (int) data);
		} else if (data instanceof Boolean) {
			preparedStatement.setBoolean(parameterIndex, (boolean) data);
		}
	}
}
