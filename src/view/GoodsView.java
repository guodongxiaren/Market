package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableColumn;

import odbc.QueryTable;

@SuppressWarnings("serial")
public class GoodsView extends JPanel {
	private JButton jbadd;

	public GoodsView() {
		this.setLayout(new BorderLayout());
		QueryTable q = new QueryTable("goods");
		JTable table = new JTable(q.getData(), q.getMetaData());
		// table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		TableColumn aColumn = table.getColumnModel().getColumn(0);
		aColumn.setCellEditor(table.getDefaultEditor(Boolean.class));
		aColumn.setCellRenderer(table.getDefaultRenderer(Boolean.class));
		JScrollPane sp = new JScrollPane(table);
		sp.setBounds(0, 0, 1000, 500);
		JPanel phead = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jbadd = new JButton("添加");
		jbadd.addActionListener(new AddListener());
		phead.add(jbadd);
		add(phead, BorderLayout.NORTH);
		add(sp, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.add(new GoodsView());
		frame.setSize(1000, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}

class AddListener implements ActionListener {
	private String colname[] = { "商品编号", "商品名称", "供应商", "商品类型", "商标", "商品型号",
			"描述", "价格", "库存量" };
	private JLabel label[] = new JLabel[9];
	private JTextField field[] = new JTextField[9];
	private JButton jbok;

	@Override
	public void actionPerformed(ActionEvent e) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel(new GridLayout(9, 2, 5, 5));
		for (int i = 0; i < 9; i++) {
			label[i] = new JLabel(colname[i]);
			field[i] = new JTextField();
			panel.add(label[i]);
			panel.add(field[i]);
		}

		frame.add(panel, BorderLayout.NORTH);
		jbok = new JButton("确定");
		frame.add(jbok, BorderLayout.CENTER);
		frame.setSize(300, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
