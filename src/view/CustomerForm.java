package view;

import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class CustomerForm extends Form {
	private String[] fields = {"编号","名称","注册名","密码","注册时间","信誉等级","地址","邮编","联系电话","邮箱地址","备注信息"};
	public CustomerForm() {
		super("customer");
		setColName(fields);
		setTitle("客户列表");
	}
	@Override
	protected void create() {
		SingleForm sf = new SingleForm(fields){

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		};

	}

}
