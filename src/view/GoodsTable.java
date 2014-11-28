package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class GoodsTable extends JPanel {

	private static final String[] columns = { "商品编号", "商品名称", "供应商", "商品类型",
			"商标", "商品型号", "描述", "单价", "库存" };
	private String[][]data={
			{"1","2","3","4","5","6","7","8","9"}
	};
	public GoodsTable() {
		JTable table = new JTable(data,columns);
		JScrollPane sp = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		add(sp);
	}

	public static void main(String[] args) {
//		GoodsTable frame = new GoodsTable();
//		frame.setSize(200, 100);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);

	}

}
