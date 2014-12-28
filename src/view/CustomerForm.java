package view;

import java.awt.event.ActionEvent;

import db.Update;
import entity.Customer;

@SuppressWarnings("serial")
public class CustomerForm extends Form {
	private String[] fields = { "编号", "名称", "注册名", "密码", "注册时间", "信誉等级", "地址",
			"邮编", "联系电话", "邮箱地址", "备注信息" };

	public CustomerForm() {
		super("customer");
		setColName(fields);
		setTitle("客户列表");
	}

	@Override
	protected void create() {
		SingleForm sf = new SingleForm(fields) {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] input = getInput();
				int id = Integer.parseInt(input[0]);
				int creditGrade = Integer.parseInt(input[5]);
				Customer cus = new Customer(id, input[1], input[2], input[3],
						input[4], creditGrade, input[6], input[7], input[8],
						input[9], input[10]);
				Update.insert(cus);
				CustomerForm.this.update();
			}

		};

	}

}
