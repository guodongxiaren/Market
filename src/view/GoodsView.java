package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import odbc.CURD;
import odbc.QueryTable;
import bean.Goods;

@SuppressWarnings("serial")
public class GoodsView extends JPanel {
	private JTable table;
	private Vector<Vector<Object>> rowData;

	public GoodsView() {
		this.setLayout(new BorderLayout());
		QueryTable q = new QueryTable("goods");
		rowData = q.getData();
		table = new JTable(rowData, q.getMetaData());
		// table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		TableColumn aColumn = table.getColumnModel().getColumn(0);
		aColumn.setCellEditor(table.getDefaultEditor(Boolean.class));
		aColumn.setCellRenderer(table.getDefaultRenderer(Boolean.class));
		JScrollPane sp = new JScrollPane(table);

		JPanel phead = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton jbadd = new JButton("添加");
		jbadd.addActionListener(new AddListener());
		JButton jbdel = new JButton("删除");
		jbdel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				delData();

			}
		});
		JButton jbupdate = new JButton("更新");
		phead.add(jbadd);
		phead.add(jbdel);
		phead.add(jbupdate);
		add(phead, BorderLayout.NORTH);
		add(sp, BorderLayout.CENTER);
	}

	public void delData() {
		TableModel tm = table.getModel();
		for (int i = 0; i < rowData.size(); i++) {
			boolean b = (boolean) tm.getValueAt(i, 0);
			if (b == false)
				System.out.println("Ok");
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.add(new GoodsView());
		frame.setSize(1000, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}

class AddListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		@SuppressWarnings("unused")
		GoodsItem gi = new GoodsItem();
	}

}

@SuppressWarnings("serial")
class GoodsItem extends JDialog implements ActionListener {
	private String colname[] = { "商品编号", "商品名称", "供应商", "商品类型", "商标", "商品型号",
			"描述", "价格", "库存量" };
	private JLabel label[] = new JLabel[9];
	private JTextField field[] = new JTextField[9];
	private JButton jbok;
	private JComboBox<String> cbSupplier, cbGoodsType;

	public GoodsItem() {
		setModal(true);
		JPanel panel = new JPanel(new GridLayout(9, 2, 5, 5));
		panel.setBorder(new EmptyBorder(10, 50, 10, 10));
		QueryTable qt = new QueryTable();
		qt.setTable("supplier");
		Vector<String> sup = qt.getColData("suppliername");
		qt.setTable("goodsType");
		Vector<String> type = qt.getColData("goodstypename");
		for (int i = 0; i < 9; i++) {
			label[i] = new JLabel(colname[i]);
			panel.add(label[i]);
			if (i == 2) {
				cbSupplier = new JComboBox<>(sup);
				panel.add(cbSupplier);
			} else if (i == 3) {
				cbGoodsType = new JComboBox<>(type);
				panel.add(cbGoodsType);
			} else {
				field[i] = new JTextField();
				panel.add(field[i]);
			}

		}

		add(panel, BorderLayout.NORTH);
		jbok = new JButton("确定");
		jbok.addActionListener(this);
		JPanel pbottom = new JPanel();
		pbottom.add(jbok);
		add(pbottom, BorderLayout.CENTER);
		setSize(300, 400);
		setLocationRelativeTo(null);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int id = Integer.parseInt(field[0].getText());
		double price = Double.parseDouble(field[7].getText());
		int storage = Integer.parseInt(field[8].getText());
		Goods goods = new Goods(id, field[1].getText(),1,
				1, field[4].getText(), field[5].getText(),
				field[6].getText(), price, storage);
		CURD.insert(goods);
	}
}