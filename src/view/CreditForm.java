package view;

import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class CreditForm extends Form {
	private String[] fields ={"�����ȼ�","�ȼ�����"};
	public CreditForm() {
		super("creditgrade");
		setColName(fields);
		setTitle("�����ȼ��б�");
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
