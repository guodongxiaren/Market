package view;

import javax.swing.JFrame;

public class GoodsForm extends Form {

	public GoodsForm() {
		super("goods");
	}

	@Override
	protected void create() {
		GoodsItem gi = new GoodsItem();
	}

	@Override
	protected void delete() {
		// TODO Auto-generated method stub

	}
	public static void main(String[]args){
		GoodsForm gf = new GoodsForm();
		JFrame frame = new JFrame();
		frame.add(gf);
		frame.setSize(1000, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
