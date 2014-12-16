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
	// �����
	private JPanel mainPanel;
	// ��Ƭ����
	private CardLayout cardLayout;
	// �˵������б���Ʒ����Ʒ����,�ͻ�����Ӧ�̣��ͻ��ȼ�������
	private JMenuItem goodsList,goodsType,cusList,supList,creditGrade,ordersList;
	public Main() {
		JMenuBar jmb = new JMenuBar();
		setJMenuBar(jmb);
		// ��Ʒ�˵�
		JMenu goods = new JMenu("��Ʒ");
		goodsList = new JMenuItem("��Ʒ�б�");
		goodsList.addActionListener(new ListListener());
		goods.add(goodsList);

		goods.addSeparator();
		goodsType = new JMenuItem("��Ʒ����");
		goodsType.addActionListener(new ListListener());
		goods.add(goodsType);
		jmb.add(goods);
		// �ͻ��˵�
		JMenu customer = new JMenu("�ͻ�");
		cusList = new JMenuItem("�ͻ��б�");
		cusList.addActionListener(new ListListener());
		customer.add(cusList);

		customer.addSeparator();
		creditGrade = new JMenuItem("�����ȼ�");
		creditGrade.addActionListener(new ListListener());
		customer.add(creditGrade);
		jmb.add(customer);

		// ��Ӧ�̲˵�
		JMenu supplier = new JMenu("��Ӧ��");
		supList = new JMenuItem("��Ӧ���б�");
		supList.addActionListener(new ListListener());
		supplier.add(supList);
		jmb.add(supplier);
		// �����˵�
		JMenu orders = new JMenu("����");
		ordersList = new JMenuItem("�����б�");
		ordersList.addActionListener(new ListListener());
		orders.add(ordersList);
		jmb.add(orders);
		// �����
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
			//��ȡ�����¼���Դ�ؼ�
			Object ob = e.getSource();
			//Ĭ�ϵĵ��õĿ�Ƭ����Ϊgoods��
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
		UIManager.put("Menu.font", new Font("����", Font.PLAIN, 15));
		UIManager.put("MenuItem.font", new Font("����", Font.PLAIN, 12));
	}
}
