package odbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConn {
	public Connection conn ;
	public Connection getConnection(){
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			String url = "jdbc:odbc:market";
			conn = DriverManager.getConnection(url);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (conn != null) {
			System.out.println("数据库连接成功");
		}
		return conn;
	}
	public static void main(String[]args){
		GetConn get = new GetConn();
		get.getConnection();
	}
}
