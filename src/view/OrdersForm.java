package view;

import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.JTable;

import res.Table;
import db.QueryTable;

@SuppressWarnings("serial")
public class OrdersForm extends Form {
	private Vector<String> customerId, customerName, goodsId, goodsName;

	public OrdersForm() {
		super("orders");
		setColName(Table.order.fields);
		setTitle(Table.title.order);

		QueryTable qt = new QueryTable();
		qt.setTable("customer");
		customerName = qt.getColData("customername");
		customerId = qt.getColData("customerid");
		qt.setTable("goods");
		goodsName = qt.getColData("goodsname");
		goodsId = qt.getColData("goodsid");
		JTable table = getTable();
		for (int i = 0; i < table.getRowCount(); i++) {
			String ob = (String) table.getValueAt(i, 2);
			int index = customerId.indexOf(ob);

			table.setValueAt(customerName.get(index).trim(), i, 2);
			ob = (String) table.getValueAt(i, 3);
			index = goodsId.indexOf(ob);
			table.setValueAt(goodsName.get(index).trim(), i, 3);
		}
	}

	@SuppressWarnings("unused")
	@Override
	protected void create() {
		SingleForm sf = new SingleForm(Table.order.fields) {

			@Override
			public void actionPerformed(ActionEvent e) {

			}

		};
	}
}
