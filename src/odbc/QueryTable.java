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
	private String table;

	public QueryTable() {
		Connection conn = GetConn.getConnection();
		try {
			stat = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public QueryTable(String table) {
		this();
		this.table = table;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public Vector<Vector<Object>> getData() {
		Vector<Vector<Object>> data = new Vector<>();
		ResultSetMetaData rsmd;
		try {
			rs = stat.executeQuery("select * from " + table);
			rsmd = rs.getMetaData();
			while (rs.next()) {
				Vector<Object> row = new Vector<>();
				row.addElement(new Boolean(false));
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					String name = rs.getString(i);
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

	public Vector<String> getColData(String colname) {
		Vector<String> colData = new Vector<>();
		try {
			rs = stat.executeQuery("select " + colname + " from " + table);
			while (rs.next()) {
				String name = rs.getString(1);
				colData.addElement(name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return colData;
	}

	public Vector<Vector<String>> getSummary() {
		Vector<Vector<String>> data = new Vector<>();
		// 查询商品，订单，客户和供应商的数量
		String sql = "select count(*) from goods union all "
				+ "select count(*) from customer union all "
				+ "select count (*) from orders union all "
				+ "select count(*) from supplier";
		try {
			rs = stat.executeQuery(sql);
			Vector<String> coldata = new Vector<>();
			while (rs.next()) {
				coldata.addElement(rs.getString(1));
			}
			data.addElement(coldata);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}
}
