package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import odbc.QueryTable;

@SuppressWarnings("serial")
public class GoodsTable extends JPanel {

	public GoodsTable() {
		    QueryTable q = new QueryTable("goods");
			JTable table = new JTable(q.getData(), q.getMetaData());
//			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

			JScrollPane sp = new JScrollPane(table);
			sp.setBounds(0, 0, 1000, 500);
			add(sp);

	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.add(new GoodsTable());
		frame.setSize(1000, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
