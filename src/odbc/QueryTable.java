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
	private Vector<Vector<String>> data;
	private String table;

	public QueryTable(String table) {
		this.table = table;
		GetConn gc = new GetConn();
		Connection conn = gc.getConnection();
		try {
			stat = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		data = new Vector<>();
	}

	public Vector<Vector<String>> getData() {
		try {
			rs = stat.executeQuery("select * from " + table);

			while (rs.next()) {
				Vector<String> row2 = new Vector<>();
				for (int i = 1; i <= 9; i++) {
					String name = rs.getString(i);
					if (name == null) {
						row2.addElement(null);
						continue;
					}
					row2.addElement(name);
				}
				data.addElement(row2);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	public Vector<String> getMetaData() {
		Vector<String> row = new Vector<String>();
		ResultSetMetaData rsmd;
		try {
			rsmd = rs.getMetaData();
			for (int i = 1; i <= rsmd.getColumnCount(); ++i)
				row.addElement(rsmd.getColumnName(i));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return row;
	}
}
