package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import odbc.QueryTable;

@SuppressWarnings("serial")
public abstract class Form extends JPanel {

	private JButton jbAdd, jbDel, jbUpd;
	private JTable table;
	// ����һ�����Ϸ������
	private JPanel phead = new JPanel(new FlowLayout(FlowLayout.LEFT));
	// ���ڷ�ֹ�������
	private JScrollPane sp;
	protected Vector<Vector<Object>> rowData;
	protected String tablename;
	public Form(String tablename) {
		this.tablename = tablename;
		setLayout(new BorderLayout());
		update();
		sp = new JScrollPane(table);
		// ������ť
		jbAdd = new JButton("���");
		jbDel = new JButton("ɾ��");
		jbUpd = new JButton("����");

//		jbAdd.addActionListener(createListener);
//		jbDel.addActionListener(deleteListener);
//		jbUpd.addActionListener(updateListener);

		phead.add(jbAdd);
		phead.add(jbDel);
		phead.add(jbUpd);

		add(phead, BorderLayout.NORTH);
		add(sp, BorderLayout.CENTER);
	}

	protected abstract void create();

	protected abstract void delete();

	protected void update() {
		QueryTable q = new QueryTable(tablename);
		rowData = q.getData();
		table = new JTable(rowData, q.getMetaData());
	};

	private ActionListener createListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			create();

		}
	};
	private ActionListener deleteListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			delete();

		}
	};
	private ActionListener updateListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			update();

		}
	};
}
