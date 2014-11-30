package odbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;

import bean.Goods;

public class Insert {
	public static void insert(Goods goods){
		Connection conn = GetConn.getConnection();
		String sql = "insert into goods values(?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps =  conn.prepareStatement(sql);
			ps.setLong(1, goods.getGoodsid());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
