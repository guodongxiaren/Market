package view;

import java.awt.event.ActionEvent;

import res.Table;
import db.Update;
import entity.CreditGrade;

@SuppressWarnings("serial")
public class CreditForm extends Form {

	public CreditForm() {
		super("creditgrade");
		setColName(Table.creditGrade.fields);
		setTitle(Table.title.creditGrade);
	}

	@Override
	protected void create() {

		SingleForm sf = new SingleForm(Table.creditGrade.fields) {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] input = getInput();
				int id = Integer.parseInt(input[0]);
				CreditGrade cg = new CreditGrade(id, input[1]);
				Update.insert(cg);
				CreditForm.this.update();
			}

		};
	}

}
