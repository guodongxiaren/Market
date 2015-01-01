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
	// 菜单项
	private JMenuItem goodsList, goodsType, cusList, supList, creditGrade,
			ordersList;

	public Main() {
		JMenuBar jmb = new JMenuBar();
		setJMenuBar(jmb);
		// 商品项
		JMenu goods = new JMenu("��Ʒ");
		goodsList = new JMenuItem("��Ʒ�б�");
		goodsList.addActionListener(new ListListener());
		goods.add(goodsList);

		goods.addSeparator();
		goodsType = new JMenuItem("��Ʒ����");
		goodsType.addActionListener(new ListListener());
		goods.add(goodsType);
		jmb.add(goods);
		// 客户项
		JMenu customer = new JMenu("�ͻ�");
		cusList = new JMenuItem("�ͻ��б�");
		cusList.addActionListener(new ListListener());
		customer.add(cusList);

		customer.addSeparator();
		creditGrade = new JMenuItem("�����ȼ�");
		creditGrade.addActionListener(new ListListener());
		customer.add(creditGrade);
		jmb.add(customer);

		// 供应商项
		JMenu supplier = new JMenu("��Ӧ��");
		supList = new JMenuItem("��Ӧ���б�");
		supList.addActionListener(new ListListener());
		supplier.add(supList);
		jmb.add(supplier);
		// 订单项
		JMenu orders = new JMenu("����");
		ordersList = new JMenuItem("�����б�");
		ordersList.addActionListener(new ListListener());
		orders.add(ordersList);
		jmb.add(orders);
		// 构建卡片布局
		cardLayout = new CardLayout();
		mainPanel = new JPanel(cardLayout);
		mainPanel.add(new SummaryPanel(), "summary");
		mainPanel.add(new GoodsForm(), "goods");
		mainPanel.add(new GoodsTypeForm(), "goodsType");
		mainPanel.add(new CustomerForm(), "customer");
		mainPanel.add(new SupplierForm(), "supplier");
		mainPanel.add(new CreditForm(), "creditGrade");
		mainPanel.add(new OrdersForm(), "orders");
		add(mainPanel);
	}

	public static void main(String[] args) {
		initUI();
		Main m = new Main();
		m.setSize(900, 500);
		m.setLocationRelativeTo(null);
		m.setDefaultCloseOperation(EXIT_ON_CLOSE);
		m.setVisible(true);
	}

	class ListListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// 获得触发事件的源组件
			Object ob = e.getSource();
			// 缺省为goods菜单项
			String name = "goods";
			if (ob == cusList)
				name = "customer";
			else if (ob == supList)
				name = "supplier";
			else if (ob == creditGrade)
				name = "creditGrade";
			else if (ob == ordersList)
				name = "orders";
			else if (ob == goodsType)
				name = "goodsType";
			cardLayout.show(mainPanel, name);
		}

	}

	/**
	 * 设置UI风格
	 */
	private static void initUI() {
		try {
			UIManager
					.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		UIManager.put("Menu.font", new Font("����", Font.PLAIN, 15));
		UIManager.put("MenuItem.font", new Font("����", Font.PLAIN, 12));
	}
}
