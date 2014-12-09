package odbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.CreditGrade;
import bean.Customer;
import bean.Goods;
import bean.GoodsType;
import bean.Supplier;

public class CURD {
	static Connection conn = GetConn.getConnection();

	/*
	 * 插入商品数据到商品表
	 */
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

	/*
	 * 插入客户数据到客户表
	 */
	public static void insert(Customer cus) {
		String sql = "insert into goods values(?,?,?,?,?,?,?,?,?,?,?)";
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

	public static void insert(Supplier sup) {
		String sql = "insert into supplier values(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, sup.getSupplierid());
			ps.setString(2, sup.getSuppliername());
			ps.setString(3, sup.getLoginname());
			ps.setString(4, sup.getPassword());
			ps.setString(5, sup.getLogindate());
			ps.setInt(6, sup.getCreditgradeid());
			ps.setString(7, sup.getDescription());
			ps.setString(8, sup.getAddress());
			ps.setString(9, sup.getZipcode());
			ps.setString(10, sup.getTel());
			ps.setString(11, sup.getEmail());
			ps.setString(12, sup.getNote());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insert(GoodsType gt) {
		String sql = "insert into goodstype values(?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, gt.getGoodsTypeId());
			ps.setString(2, gt.getGoodsTypeName());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insert(CreditGrade cg) {
		String sql = "insert into creditgrade values(?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cg.getCreditGradeId());
			ps.setString(2, cg.getCreditGradeName());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param id
	 *            要删除的id
	 * @param tablename
	 *            进行删除操作的表名
	 * @return
	 */
	public static boolean delete(int id, String tablename) {
		String idname = null;
		switch (tablename) {
		case "goods":
			idname = "goodsid";
			break;
		case "customer":
			idname = "customerid";
			break;
		case "supplier":
			idname = "supplierid";
			break;
		case "orders":
			idname = "orderid";
			break;
		case "creditgrade":
			idname = "creditgradeid";
			break;
		case "goodstype":
			idname = "goodstypeid";
			break;
		}
		if (idname == null)
			return false;
		String sql = "delete from " + tablename + " where " + idname + " = ?";
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
