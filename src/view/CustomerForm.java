package view;

import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class CustomerForm extends Form {
	private String[] fields = {"���","����","ע����","����","ע��ʱ��","�����ȼ�","��ַ","�ʱ�","��ϵ�绰","�����ַ","��ע��Ϣ"};
	public CustomerForm() {
		super("customer");
		setColName(fields);
		setTitle("�ͻ��б�");
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
