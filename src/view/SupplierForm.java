package view;

import java.awt.event.ActionEvent;
import odbc.CURD;
import bean.Supplier;

@SuppressWarnings("serial")
public class SupplierForm extends Form {
	
	private String[] fields = {"���","����","ע����","����","ע��ʱ��","�����ȼ�","��������","��ַ","�ʱ�","��ϵ�绰","�����ַ","��ע��Ϣ"};
	public SupplierForm() {
		super("supplier");
		setColName(fields);
		setTitle("��Ӧ���б�");
	}

	@SuppressWarnings("unused")
	@Override
	protected void create() {
		SingleForm sf = new SingleForm(fields){

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] input = getInput();
				int id = Integer.parseInt(input[0]);
				int creditGrade = Integer.parseInt(input[5]);
				Supplier sup = new Supplier(id, input[1], input[2], input[3],
						input[4], creditGrade, input[6], input[7], input[8],
						input[9], input[10],input[11]);
				CURD.insert(sup);
				SupplierForm.this.update();
				clearInput();
			}

		};
	}

}
