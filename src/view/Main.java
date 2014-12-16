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

@SuppressWarnings("serial")
public class Main extends JFrame {
	// 主面板
	private JPanel mainPanel;
	// 卡片布局
	private CardLayout cardLayout;
	// 菜单各种列表：商品，商品类型,客户，供应商，客户等级，订单
	private JMenuItem goodsList,goodsType,cusList,supList,creditGrade,ordersList;
	public Main() {
		JMenuBar jmb = new JMenuBar();
		setJMenuBar(jmb);
		// 商品菜单
		JMenu goods = new JMenu("商品");
		goodsList = new JMenuItem("商品列表");
		goodsList.addActionListener(new ListListener());
		goods.add(goodsList);

		goods.addSeparator();
		goodsType = new JMenuItem("商品类型");
		goodsType.addActionListener(new ListListener());
		goods.add(goodsType);
		jmb.add(goods);
		// 客户菜单
		JMenu customer = new JMenu("客户");
		cusList = new JMenuItem("客户列表");
		cusList.addActionListener(new ListListener());
		customer.add(cusList);

		customer.addSeparator();
		creditGrade = new JMenuItem("信誉等级");
		creditGrade.addActionListener(new ListListener());
		customer.add(creditGrade);
		jmb.add(customer);

		// 供应商菜单
		JMenu supplier = new JMenu("供应商");
		supList = new JMenuItem("供应商列表");
		supList.addActionListener(new ListListener());
		supplier.add(supList);
		jmb.add(supplier);
		// 订单菜单
		JMenu orders = new JMenu("订单");
		ordersList = new JMenuItem("订单列表");
		ordersList.addActionListener(new ListListener());
		orders.add(ordersList);
		jmb.add(orders);
		// 主面板
		cardLayout = new CardLayout();
		mainPanel = new JPanel(cardLayout);
		mainPanel.add(new SummaryPanel(),"summary");
		mainPanel.add(new GoodsForm(), "goods");
		mainPanel.add(new GoodsTypeForm(),"goodsType");
		mainPanel.add(new CustomerForm(), "customer");
		mainPanel.add(new SupplierForm(), "supplier");
		mainPanel.add(new CreditForm(), "creditGrade");
		mainPanel.add(new OrdersForm(),"orders");
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
	class ListListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//获取触发事件的源控件
			Object ob = e.getSource();
			//默认的调用的卡片布局为goods表
			String name = "goods";
			if(ob == cusList)
				name = "customer";
			else if(ob == supList)
				name = "supplier";
			else if(ob == creditGrade)
				name = "creditGrade";
			else if(ob == ordersList)
				name = "orders";
			else if(ob == goodsType)
				name = "goodsType";
			cardLayout.show(mainPanel, name);
		}
		
	}
	private static void initUI() {
		try {
//			UIManager.setLookAndFeel(new javax.swing.plaf.nimbus.NimbusLookAndFeel());
			UIManager
					.setLookAndFeel(new com.sun.java.swing.plaf.windows.WindowsLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		UIManager.put("Menu.font", new Font("宋体", Font.PLAIN, 15));
		UIManager.put("MenuItem.font", new Font("宋体", Font.PLAIN, 12));
	}
}
