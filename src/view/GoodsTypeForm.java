package view;

import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class GoodsTypeForm extends Form {
	
	private String[] fields = {"���","��������"};
	public GoodsTypeForm() {
		super("goodstype");
		setColName(fields);
		setTitle("��Ʒ�����б�");
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
