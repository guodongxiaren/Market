package odbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;

import bean.Goods;

public class CURD {
	public static void insert(Goods goods){
		Connection conn = GetConn.getConnection();
		String sql = "insert into goods values(?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps =  conn.prepareStatement(sql);
			ps.setInt(1, goods.getGoodsid());
			ps.setString(2, goods.getGoodsname());
			ps.setInt(3, goods.getSupplierid());
			ps.setInt(4, goods.getGoodstypeid());
			ps.setString(5, goods.getBrand());
			ps.setString(6, goods.getGoodsmodel());
			ps.setString(7, goods.getDescription());
			ps.setDouble(8, goods.getPrice());
			ps.setInt(9, goods.getStorage());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
