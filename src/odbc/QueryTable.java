package odbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class QueryTable {
	private Statement stat;
	private ResultSet rs;
	private Vector<Vector<Object>> data;
	private String table;

	public QueryTable(String table) {
		this.table = table;
		Connection conn = GetConn.getConnection();
		try {
			stat = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		data = new Vector<>();
	}

	public Vector<Vector<Object>> getData() {
		try {
			rs = stat.executeQuery("select * from " + table);

			while (rs.next()) {
				Vector<Object> row = new Vector<>();
				row.addElement(new Boolean(false));
				for (int i = 1; i <= 9; i++) {
					String name = rs.getString(i);
					if (name == null) {
						row.addElement(null);
						continue;
					}
					row.addElement(name);
				}
				data.addElement(row);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	public Vector<String> getMetaData() {
		Vector<String> row = new Vector<>();
		ResultSetMetaData rsmd;
		try {
			rsmd = rs.getMetaData();
			row.addElement(" ");
			for (int i = 1; i <= rsmd.getColumnCount(); ++i)
				row.addElement(rsmd.getColumnName(i));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return row;
	}
}
