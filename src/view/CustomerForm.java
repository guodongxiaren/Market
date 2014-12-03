package view;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class CustomerForm extends Form {
	
	public CustomerForm() {
		super("customer");
	}
	@Override
	protected void create() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		CustomerForm c  = new CustomerForm();
		JFrame frame = new JFrame();
		frame.add(c);
		frame.setSize(1000, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
