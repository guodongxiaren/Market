package view;

import java.awt.event.ActionEvent;

import res.Table;
import db.Update;
import entity.GoodsType;

@SuppressWarnings("serial")
public class GoodsTypeForm extends Form {

	public GoodsTypeForm() {
		super("goodstype");
		setColName(Table.goodsType.fields);
		setTitle(Table.title.goodsType);
	}

	@Override
	protected void create() {
		SingleForm sf = new SingleForm(Table.goodsType.fields) {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] input = getInput();
				int id = Integer.parseInt(input[0]);
				GoodsType gt = new GoodsType(id, input[1]);
				Update.insert(gt);
				GoodsTypeForm.this.update();
			}

		};
	}

}
