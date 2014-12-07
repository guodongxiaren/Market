package view;

import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class CreditForm extends Form {
	private String[] fields ={"信誉等级","等级名称"};
	public CreditForm() {
		super("creditgrade");
		setColName(fields);
		setTitle("信誉等级列表");
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
