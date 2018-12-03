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
public class Report3 extends MenuItemBase {

	private final static String DISPLAY_NAME = "Books with Similar Topic";
	
	public Report3() {
		super(DISPLAY_NAME);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
        String subject = (String)JOptionPane.showInputDialog(
                getParent(),
                "What subject do you want to look for?",
                "Field",
                JOptionPane.PLAIN_MESSAGE);
		
        String tempView1 = "CREATE VIEW v_subjectDescription AS\r\n" + 
        		"	SELECT isbn, title, yearofpublication, abstract\r\n" + 
        		"    FROM book\r\n" + 
        		"    WHERE (abstract LIKE '%" + subject + "%') OR (title LIKE '%" + subject + "%');";
        String dropView1 = "drop view v_subjectDescription;";
        
        String tempView2 = "CREATE VIEW v_subjectKeyword AS\r\n" + 
        		"	select isbn, tag\r\n" + 
        		"    FROM keyword, bookkeyword\r\n" + 
        		"    WHERE (tag LIKE '%" + subject + "%') AND keyword.id = bookkeyword.keyword_id;";
        String dropView2 = "drop view v_subjectKeyword;";
        
        String query = "SELECT book.isbn, book.title, book.yearofpublication\r\n" + 
        		"FROM book, v_subjectdescription\r\n" + 
        		"WHERE book.isbn = v_subjectdescription.isbn\r\n" + 
        		"UNION\r\n" + 
        		"SELECT book.isbn, book.title, book.yearofpublication\r\n" + 
        		"FROM book, v_subjectkeyword\r\n" + 
        		"WHERE book.isbn = v_subjectkeyword.isbn;";
        
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
