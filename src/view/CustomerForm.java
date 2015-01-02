package view;

import java.awt.event.ActionEvent;

import res.Table;
import db.Update;
import entity.Customer;

@SuppressWarnings("serial")
public class CustomerForm extends Form {

	public CustomerForm() {
		super("customer");
		setColName(Table.customer.fields);
		setTitle(Table.title.customer);
	}

	@Override
	protected void create() {
		SingleForm sf = new SingleForm(Table.customer.fields) {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] input = getInput();
				int id = Integer.parseInt(input[0]);
				int creditGrade = Integer.parseInt(input[5]);
				Customer cus = new Customer(id, input[1], input[2], input[3],
						input[4], creditGrade, input[6], input[7], input[8],
						input[9], input[10]);
				Update.insert(cus);
				CustomerForm.this.update();
			}

		};

	}

}
