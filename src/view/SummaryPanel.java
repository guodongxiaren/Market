package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import db.QueryTable;

@SuppressWarnings("serial")
public class SummaryPanel extends JPanel {

	public SummaryPanel() {
		setLayout(new BorderLayout());
		QueryTable qt = new QueryTable();
		Vector<Vector<String>> data = qt.getSummary();
		Vector<String> colname = new Vector<String>();
		colname.addElement("商品数量");
		colname.addElement("订单数量");
		colname.addElement("客户数量");
		colname.addElement("供应商数量");
		TableModel tm = new DefaultTableModel(data, colname);
		JTable table = new JTable();
		table.setModel(tm);
		JScrollPane sp = new JScrollPane(table);
		JLabel label = new JLabel("信息汇总");
		label.setFont(new Font("微软雅黑",Font.BOLD,15));
		JPanel p = new JPanel();
		p.add(label);
		add(p,BorderLayout.NORTH);
		add(sp,BorderLayout.CENTER);
	}

}
