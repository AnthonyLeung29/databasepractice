package com.app.gui.menu.report;

import java.awt.event.ActionEvent;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.app.database.DatabaseDriver;
import com.app.database.DatabaseSelector;
import com.app.gui.bases.MenuItemBase;

@SuppressWarnings("serial")
public class Report1 extends MenuItemBase {

	private final static String DISPLAY_NAME = "Authors' Publications";

	public Report1() {
		super(DISPLAY_NAME);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
        String name = (String)JOptionPane.showInputDialog(
                getParent(),
                "What's the author's name?",
                "Field",
                JOptionPane.PLAIN_MESSAGE);
		
        String tempView = "CREATE VIEW v_authorNames AS\r\n" + 
        		"	SELECT isbn, Author_ID, firstName, middleName, familyName\r\n" + 
        		"    FROM bookauthor, peopleinvolved\r\n" + 
        		"    WHERE bookauthor.Author_ID = peopleinvolved.ID;";
        String dropView = "drop view v_authorNames;";
        
        String query = "SELECT book.isbn, title, YearOfPublication\r\n" + 
        		"FROM book, v_authorNames\r\n" + 
        		"WHERE book.isbn = v_authorNames.isbn AND v_authornames.firstName = \"" + name + "\" ORDER BY book.isbn ASC;";
        
        try {
            Connection con = DatabaseDriver.getConnection();
            
            Statement st = con.createStatement();
            st.executeUpdate(tempView);
            
            ResultSet rs = DatabaseSelector.queryData(con, query);
            JTable table = new JTable(buildTableModel(rs));
            
            st.executeUpdate(dropView);
            
            con.close();
            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            JOptionPane.showMessageDialog(null, new JScrollPane(table), "Data Table Preview", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "There is something wrong in the query.", "Wrong query input", JOptionPane.ERROR_MESSAGE);
        }
	}

	public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {

		ResultSetMetaData metaData = rs.getMetaData();

		// names of columns
		Vector<String> columnNames = new Vector<String>();
		int columnCount = metaData.getColumnCount();
		for (int column = 1; column <= columnCount; column++) {
			columnNames.add(metaData.getColumnName(column));
		}

		// data of the table
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		while (rs.next()) {
			Vector<Object> vector = new Vector<Object>();
			for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
				vector.add(rs.getObject(columnIndex));
			}
			data.add(vector);
		}

		return new DefaultTableModel(data, columnNames);

	}
}
