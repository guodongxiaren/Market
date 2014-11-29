package odbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConn {

	private static Connection conn;
	private GetConn(){
		
	}
	public static Connection getConnection() {
		if(conn != null)
			return conn;
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			String url = "jdbc:odbc:market;useunicode=true";
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
		GetConn.getConnection();
	}
}