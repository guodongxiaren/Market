package view;

import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import db.Update;
import db.QueryTable;
import entity.Goods;

@SuppressWarnings("serial")
public class GoodsForm extends Form {
	private String[] fields = { "��Ʒ���", "��Ʒ����", "��Ӧ��", "��Ʒ����", "�̱�", "��Ʒ�ͺ�",
			"����", "�۸�", "�����" };
	private Vector<String> supId, sup, type, goodsTypeId;

	public GoodsForm() {
		super("goods");
		setColName(fields);
		setTitle("��Ʒ�б�");
		QueryTable qt = new QueryTable();
		qt.setTable("supplier");
		sup = qt.getColData("suppliername");
		supId = qt.getColData("supplierid");
		qt.setTable("goodstype");
		type = qt.getColData("goodstypename");
		goodsTypeId = qt.getColData("goodstypeid");
		JTable table = getTable();
		for (int i = 0; i < table.getRowCount(); i++) {
			String ob = (String) table.getValueAt(i, 3);
			// ��Ϊ���ݿ�����Ʒ��Ĺ�Ӧ�̱���ֶ���NOT NULL�ġ����Դ�ʱob�ز�Ϊnull
			int index = supId.indexOf(ob);

			table.setValueAt(sup.get(index).trim(), i, 3);
			ob = (String) table.getValueAt(i, 4);
			// ��Ʒ���ͱ���ֶΣ��ǿ���Ϊnull�ģ�����Ҫ�жϡ�
			if (ob == null)
				continue;
			index = goodsTypeId.indexOf(ob);
			table.setValueAt(type.get(index).trim(), i, 4);
		}
	}

	@Override
	protected void create() {
		SingleForm sf = new GoodsSingleForm(fields);
		update();
	}

	class GoodsSingleForm extends SingleForm {
		JComponent[] comp;

		public GoodsSingleForm(String[] fields) {
			super(fields);
		}

		@Override
		protected void initUI() {
			comp = new JComponent[fields.length];
			JPanel p = getRightPanel();
			for (int i = 0; i < fields.length; i++) {
				if (i == 2) {
					comp[i] = new JComboBox<String>(sup);
				} else if (i == 3) {
					comp[i] = new JComboBox<String>(type);
				} else {
					comp[i] = new JTextField();
				}
				p.add(comp[i]);
			}
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			int id = Integer.parseInt(((JTextField) comp[0]).getText());
			double price = Double.parseDouble(((JTextField) comp[7]).getText());
			int storage = Integer.parseInt(((JTextField) comp[8]).getText());
			int i = ((JComboBox<?>) comp[2]).getSelectedIndex();
			int supplierid = Integer.parseInt(supId.elementAt(i));
			i = ((JComboBox<?>) comp[3]).getSelectedIndex();
			int goodstypeid = Integer.parseInt(goodsTypeId.elementAt(i));
			Goods goods = new Goods(id, ((JTextField) comp[1]).getText(),
					supplierid, goodstypeid, ((JTextField) comp[4]).getText(),
					((JTextField) comp[5]).getText(),
					((JTextField) comp[6]).getText(), price, storage);
			Update.insert(goods);
		}

	};
}
