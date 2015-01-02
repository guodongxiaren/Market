package view;

import java.awt.event.ActionEvent;

import res.Table;
import db.Update;
import entity.Supplier;

@SuppressWarnings("serial")
public class SupplierForm extends Form {
	
	public SupplierForm() {
		super("supplier");
		setColName(Table.supplier.fields);
		setTitle(Table.title.supplier);
	}

	@SuppressWarnings("unused")
	@Override
	protected void create() {
		SingleForm sf = new SingleForm(Table.supplier.fields){

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] input = getInput();
				int id = Integer.parseInt(input[0]);
				int creditGrade = Integer.parseInt(input[5]);
				Supplier sup = new Supplier(id, input[1], input[2], input[3],
						input[4], creditGrade, input[6], input[7], input[8],
						input[9], input[10],input[11]);
				Update.insert(sup);
				SupplierForm.this.update();
				clearInput();
			}

		};
	}

}
