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

import res.Table;
import db.QueryTable;

@SuppressWarnings("serial")
public class SummaryPanel extends JPanel {

	public SummaryPanel() {
		setLayout(new BorderLayout());
		QueryTable qt = new QueryTable();
		Vector<Vector<String>> data = qt.getSummary();
		Vector<String> colname = new Vector<String>();
		colname.addElement(Table.summary.goodsCount);
		colname.addElement(Table.summary.orderCount);
		colname.addElement(Table.summary.customerCount);
		colname.addElement(Table.summary.supplierCount);
		TableModel tm = new DefaultTableModel(data, colname);
		JTable table = new JTable();
		table.setModel(tm);
		JScrollPane sp = new JScrollPane(table);
		JLabel label = new JLabel(Table.title.summary);
	//	label.setFont(new Font("΢���ź�",Font.BOLD,15));
		JPanel p = new JPanel();
		p.add(label);
		add(p,BorderLayout.NORTH);
		add(sp,BorderLayout.CENTER);
	}

}
