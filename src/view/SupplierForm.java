package view;

import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class SupplierForm extends Form {
	
	private String[] fields = {"���","����","ע����","����","ע��ʱ��","�����ȼ�","��������","��ַ","�ʱ�","��ϵ�绰","�����ַ","��ע��Ϣ"};
	public SupplierForm() {
		super("supplier");
		setColName(fields);
		setTitle("��Ӧ���б�");
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