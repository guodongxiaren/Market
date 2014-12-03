package odbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.Customer;
import bean.Goods;

public class CURD {
	static Connection conn = GetConn.getConnection();

	public static void insert(Goods goods) {
		String sql = "insert into goods values(?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
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

	public static void insert(Customer cus) {
		String sql = "insert into goods values(?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cus.getCustomerid());
			ps.setString(2, cus.getCustomername());
			ps.setString(3, cus.getLoginname());
			ps.setString(4, cus.getPassword());
			ps.setString(5, cus.getLogindate());
			ps.setInt(6, cus.getCreditgradeid());
			ps.setString(7, cus.getAddress());
			ps.setString(8, cus.getZipcode());
			ps.setString(9, cus.getTel());
			ps.setString(10, cus.getEmail());
			ps.setString(11, cus.getNote());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
/**
 * 
 * @param id 要删除的id
 * @param tablename 进行删除操作的表名
 * @return
 */
	public static boolean delete(int id,String tablename) {

		String sql = "delete from "+tablename+" where goodsid = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
