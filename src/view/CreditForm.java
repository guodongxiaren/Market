package view;

import java.awt.event.ActionEvent;

import odbc.CURD;
import bean.CreditGrade;

@SuppressWarnings("serial")
public class CreditForm extends Form {
	private String[] fields = { "�����ȼ�", "�ȼ�����" };

	public CreditForm() {
		super("creditgrade");
		setColName(fields);
		setTitle("�����ȼ��б�");
	}

	@Override
	protected void create() {

		SingleForm sf = new SingleForm(fields) {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] input = getInput();
				int id = Integer.parseInt(input[0]);
				CreditGrade cg = new CreditGrade(id, input[1]);
				CURD.insert(cg);
				CreditForm.this.update();
			}

		};
	}

}
