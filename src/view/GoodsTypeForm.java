package view;

import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class GoodsTypeForm extends Form {
	
	private String[] fields = {"编号","类型名称"};
	public GoodsTypeForm() {
		super("goodstype");
		setColName(fields);
		setTitle("商品类型列表");
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
