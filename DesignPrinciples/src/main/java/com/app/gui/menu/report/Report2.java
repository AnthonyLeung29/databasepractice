package com.app.gui.menu.report;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.app.database.DatabaseDriver;
import com.app.database.DatabaseSelector;
import com.app.gui.bases.MenuItemBase;

@SuppressWarnings("serial")
public class Report2 extends MenuItemBase {

	private final static String DISPLAY_NAME = "Publications in one year";
	
	public Report2() {
		super(DISPLAY_NAME);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
        String year = (String)JOptionPane.showInputDialog(
                getParent(),
                "What year do you want to look for?",
                "Field",
                JOptionPane.PLAIN_MESSAGE);
		
        String tempView1 = "CREATE VIEW v_authorNames AS\r\n" + 
        		"	SELECT isbn, Author_ID, firstName, middleName, familyName\r\n" + 
        		"    FROM bookauthor, peopleinvolved\r\n" + 
        		"    WHERE bookauthor.Author_ID = peopleinvolved.ID;";
        String dropView1 = "drop view v_authorNames;";
        
        String tempView2 = "CREATE VIEW v_sameYear AS\r\n" + 
        		"	SELECT isbn, title, yearOfPublication\r\n" + 
        		"    FROM book\r\n" + 
        		"    WHERE yearOfPublication = \"" + year + "\";";
        String dropView2 = "drop view v_sameYear;";
        
        String query = "SELECT v_sameYear.isbn, title, yearOfPublication, familyName, firstName\r\n" + 
        		"FROM v_sameYear LEFT OUTER JOIN v_authorNames \r\n" + 
        		"	ON v_sameYear.isbn = v_authorNames.isbn ORDER BY title ASC;";
        
        try {
            Connection con = DatabaseDriver.getConnection();
            
            Statement st = con.createStatement();
            st.executeUpdate(tempView1);
            st.executeUpdate(tempView2);
            
            ResultSet rs = DatabaseSelector.queryData(con, query);
            JTable table = new JTable(buildTableModel(rs));
            
            st.executeUpdate(dropView1);
            st.executeUpdate(dropView2);
            
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