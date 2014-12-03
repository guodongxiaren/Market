package view;

import java.awt.BorderLayout;
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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import odbc.CURD;
import odbc.QueryTable;
import bean.Goods;

@SuppressWarnings("serial")
public class GoodsForm extends Form {

	public GoodsForm() {
		super("goods");
	}

	@SuppressWarnings("unused")
	@Override
	protected void create() {
		GoodsItem gi = new GoodsItem();
		update();
	}
	
	public static void main(String[]args){
		GoodsForm gf = new GoodsForm();
		JFrame frame = new JFrame();
		frame.add(gf);
		frame.setSize(1000, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
@SuppressWarnings("serial")
class GoodsItem extends JDialog implements ActionListener {
	private String colname[] = { "商品编号", "商品名称", "供应商", "商品类型", "商标", "商品型号",
			"描述", "价格", "库存量" };
	private JLabel label[] = new JLabel[9];
	private JTextField field[] = new JTextField[9];
	private JButton jbok;
	JComboBox<?> cbSupplier;
	private JComboBox<?> cbGoodsType;
	private Vector<String> supId;
	private Vector<String> goodsTypeId;
	public GoodsItem() {
		setModal(true);
		JPanel panel = new JPanel(new GridLayout(9, 2, 5, 5));
		//边距
		panel.setBorder(new EmptyBorder(10, 50, 10, 10));
		
		QueryTable qt = new QueryTable();
		qt.setTable("supplier");
		Vector<String> sup = qt.getColData("suppliername");
		supId = qt.getColData("supplierid");
		qt.setTable("goodsType");
		Vector<String> type = qt.getColData("goodstypename");
		goodsTypeId = qt.getColData("goodstypeid");
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
		int i = cbSupplier.getSelectedIndex();
		int supplierid = Integer.parseInt(supId.elementAt(i));
		i = cbGoodsType.getSelectedIndex();
		int goodstypeid = Integer.parseInt(goodsTypeId.elementAt(i));
		Goods goods = new Goods(id, field[1].getText(), supplierid, goodstypeid,
				field[4].getText(), field[5].getText(), field[6].getText(),
				price, storage);
		CURD.insert(goods);
	}
}