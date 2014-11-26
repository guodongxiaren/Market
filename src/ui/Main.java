package ui;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

@SuppressWarnings("serial")
public class Main extends JFrame {

	public Main(){
		JMenuBar jmb = new JMenuBar();
		setJMenuBar(jmb);
		JMenu customer = new JMenu("客户");
		jmb.add(customer);
		JMenu goods = new JMenu("商品");
		
		jmb.add(goods);
	}
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		UIManager.put("Menu.font",new Font("微软雅黑",21,20));
		Main m = new Main();
		m.setSize(400,500);
		m.setLocationRelativeTo(null);
		m.setDefaultCloseOperation(EXIT_ON_CLOSE);
		m.setVisible(true);
	}

}
