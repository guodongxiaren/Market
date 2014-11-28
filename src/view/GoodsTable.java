package view;

import java.awt.Font;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;

import odbc.GetConn;

@SuppressWarnings("serial")
public class GoodsTable extends JPanel {

	private String[][] data = { { "1", "2", "3", "4", "5", "6", "7", "8", "9" } };

	public GoodsTable() {

		GetConn gc = new GetConn();
		Connection conn = gc.getConnection();
		Statement s;
		Vector rows = new Vector();
		Vector row = new Vector();
//		 row.add(columns);
		try {
			s = conn.createStatement();
			ResultSet rs = s.executeQuery("select * from goods");
			ResultSetMetaData rsmd = rs.getMetaData();
			for (int i = 1; i <= rsmd.getColumnCount(); ++i)
				row.addElement(rsmd.getColumnName(i));
			System.out.println(rsmd.getColumnCount());
			while (rs.next()) {
				Vector row2 = new Vector();
				for (int i = 1; i <= 9; i++) {
					String name = rs.getString(i);
					if(name==null){
						row2.addElement(null);
						continue;
					}
					byte[] bytes = name.getBytes("gb2312");
					System.out.println(new String(bytes,"UTF-8"));
					row2.addElement(name);
				}
				rows.addElement(row2);

			}
			JTable table = new JTable(rows, row);
//			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			JScrollPane sp = new JScrollPane(table);
			add(sp);
		} catch (SQLException e) {
			e.printStackTrace();

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.add(new GoodsTable());
		frame.setSize(1000, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}
