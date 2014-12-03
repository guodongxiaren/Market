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
	// �����
	private JPanel mainPanel;
	// ��Ƭ����
	private CardLayout cardLayout;

	public Main() {
		JMenuBar jmb = new JMenuBar();
		setJMenuBar(jmb);
		// �˵�
		JMenu goods = new JMenu("��Ʒ");
		JMenuItem goodList = new JMenuItem("��Ʒ�б�");
		goods.add(goodList);
		JMenuItem goodAdd = new JMenuItem("�����Ʒ");
		goodAdd.addActionListener(null);
		goods.add(goodAdd);
		JMenuItem goodType = new JMenuItem("��Ʒ����");
		goods.add(goodType);
		jmb.add(goods);

		JMenu customer = new JMenu("�ͻ�");
		JMenuItem cusList = new JMenuItem("�ͻ��б�");
		cusList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(mainPanel, "customer");
			}
		});
		customer.add(cusList);
		JMenuItem cusAdd = new JMenuItem("��ӿͻ�");
		customer.add(cusAdd);
		jmb.add(customer);
		JMenu supplier = new JMenu("��Ӧ��");
		jmb.add(supplier);
		JMenu orders = new JMenu("����");
		jmb.add(orders);
		// �����
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
		UIManager.put("Menu.font", new Font("����", Font.PLAIN, 15));
		UIManager.put("MenuItem.font", new Font("����", Font.PLAIN, 12));

	}
}
