package view;

import java.awt.event.ActionEvent;

import db.Update;
import entity.GoodsType;

@SuppressWarnings("serial")
public class GoodsTypeForm extends Form {

	private String[] fields = { "���", "��������" };

	public GoodsTypeForm() {
		super("goodstype");
		setColName(fields);
		setTitle("��Ʒ�����б�");
	}

	@Override
	protected void create() {
		SingleForm sf = new SingleForm(fields) {

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
