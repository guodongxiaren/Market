package view;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

@SuppressWarnings("serial")
public class Main extends JFrame {

	public Main(){
		JMenuBar jmb = new JMenuBar();
		setJMenuBar(jmb);
		JMenu goods = new JMenu("商品");
		JMenuItem goodAdd = new JMenuItem("增加");
		goods.add(goodAdd);
		jmb.add(goods);
		JMenu customer = new JMenu("客户");
		jmb.add(customer);
		JMenu supplier = new JMenu("供应商");
		jmb.add(supplier);
		JMenu orders = new JMenu("订单");
		jmb.add(orders);
	}
	public static void main(String[] args) {
		initUI();
		Main m = new Main();
		m.setSize(400,500);
		m.setLocationRelativeTo(null);
		m.setDefaultCloseOperation(EXIT_ON_CLOSE);
		m.setVisible(true);
	}
	private static void initUI(){
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		UIManager.put("Menu.font",new Font("微软雅黑",Font.PLAIN,15));
		UIManager.put("MenuItem.font",new Font("微软雅黑",Font.PLAIN,15));
	}

}
