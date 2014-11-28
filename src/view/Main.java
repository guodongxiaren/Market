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
		
		JMenu goods = new JMenu("��Ʒ");
		JMenuItem goodAdd = new JMenuItem("�����Ʒ");
		goods.add(goodAdd);
		JMenuItem goodType = new JMenuItem("��Ʒ����");
		goods.add(goodType);
		jmb.add(goods);
		JMenu customer = new JMenu("�ͻ�");
		jmb.add(customer);
		JMenu supplier = new JMenu("��Ӧ��");
		jmb.add(supplier);
		JMenu orders = new JMenu("����");
		jmb.add(orders);
		GoodsTable gt = new GoodsTable();
		add(gt);
	}
	public static void main(String[] args) {
		initUI();
		Main m = new Main();
		m.setSize(800,500);
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
		UIManager.put("Menu.font",new Font("����",Font.PLAIN,15));
		UIManager.put("MenuItem.font",new Font("����",Font.PLAIN,12));
	}

}
