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
		colname.addElement("��Ʒ����");
		colname.addElement("��������");
		colname.addElement("�ͻ�����");
		colname.addElement("��Ӧ������");
		TableModel tm = new DefaultTableModel(data, colname);
		JTable table = new JTable();
		table.setModel(tm);
		JScrollPane sp = new JScrollPane(table);
		JLabel label = new JLabel("��Ϣ����");
		label.setFont(new Font("΢���ź�",Font.BOLD,15));
		JPanel p = new JPanel();
		p.add(label);
		add(p,BorderLayout.NORTH);
		add(sp,BorderLayout.CENTER);
	}

}
