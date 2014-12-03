package view;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

@SuppressWarnings("serial")
public class Main extends JFrame {
	// 主面板
	private JPanel mainPanel;
	// 卡片布局
	private CardLayout cardLayout;

	public Main() {
		JMenuBar jmb = new JMenuBar();
		setJMenuBar(jmb);
		// 菜单
		JMenu goods = new JMenu("商品");
		JMenuItem goodList = new JMenuItem("商品列表");
		goods.add(goodList);
		JMenuItem goodAdd = new JMenuItem("添加商品");
		goodAdd.addActionListener(null);
		goods.add(goodAdd);
		JMenuItem goodType = new JMenuItem("商品类型");
		goods.add(goodType);
		jmb.add(goods);

		JMenu customer = new JMenu("客户");
		JMenuItem cusList = new JMenuItem("客户列表");
		cusList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(mainPanel, "customer");
			}
		});
		customer.add(cusList);
		JMenuItem cusAdd = new JMenuItem("添加客户");
		customer.add(cusAdd);
		jmb.add(customer);
		JMenu supplier = new JMenu("供应商");
		jmb.add(supplier);
		JMenu orders = new JMenu("订单");
		jmb.add(orders);
		// 主面板
		cardLayout = new CardLayout();
		mainPanel = new JPanel(cardLayout);
		mainPanel.add(new GoodsForm(), "goods");
		mainPanel.add(new CustomerForm(), "customer");
		add(mainPanel);
	}

	public static void main(String[] args) {
		initUI();
		Main m = new Main();
		m.setSize(800, 500);
		m.setLocationRelativeTo(null);
		m.setDefaultCloseOperation(EXIT_ON_CLOSE);
		m.setVisible(true);
	}

	private static void initUI() {
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		UIManager.put("Menu.font", new Font("宋体", Font.PLAIN, 15));
		UIManager.put("MenuItem.font", new Font("宋体", Font.PLAIN, 12));

	}
}
