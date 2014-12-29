package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConn {

	private static Connection conn;

	private GetConn() {

	}

	public static Connection getConnection() {
		if (conn != null)
			return conn;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/market?user=root&password=096629";
			conn = DriverManager.getConnection(url);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (conn != null) {
			System.out.println("OK");
		}
		return conn;
	}

	public static void main(String[] args) {
		Connection conn = GetConn.getConnection();
		if (conn != null)
			System.out.println("OK");
	}
}