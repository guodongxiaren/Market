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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import odbc.CURD;
import odbc.QueryTable;

@SuppressWarnings("serial")
public abstract class Form extends JPanel {

	private JButton jbAdd, jbDel, jbUpd;
	private JTable table;
	private TableModel model;
	// 创建一个在上方的面板
	private JPanel phead = new JPanel(new FlowLayout(FlowLayout.LEFT));
	// 用于防止表格的面板
	private JScrollPane sp;
	protected Vector<Vector<Object>> rowData;
	private Vector<String> colname;
	protected String tablename;

	public Form(String tablename) {
		this.tablename = tablename;
		setLayout(new BorderLayout());
		
		QueryTable q = new QueryTable(tablename);
		rowData = q.getData();
		colname = q.getMetaData();
		model = new DefaultTableModel(rowData, colname);
		table = new JTable();

		table.setModel(model);
		TableColumn aColumn = table.getColumnModel().getColumn(0);
		aColumn.setCellEditor(table.getDefaultEditor(Boolean.class));
		aColumn.setCellRenderer(table.getDefaultRenderer(Boolean.class));
		

		sp = new JScrollPane(table);
		// 三个按钮
		jbAdd = new JButton("添加");
		jbDel = new JButton("删除");
		jbUpd = new JButton("更新");

		jbAdd.addActionListener(createListener);
		jbDel.addActionListener(deleteListener);
		jbUpd.addActionListener(updateListener);

		phead.add(jbAdd);
		phead.add(jbDel);
		phead.add(jbUpd);

		add(phead, BorderLayout.NORTH);
		add(sp, BorderLayout.CENTER);
	}

	protected abstract void create();

	protected void delete() {
		TableModel tm = table.getModel();
		for (int i = 0; i < rowData.size(); i++) {
			boolean b = (boolean) tm.getValueAt(i, 0);
			if (b == true) {
				int id = Integer.parseInt((String)tm.getValueAt(i, 1));
				CURD.delete(id,tablename);
			}
		}
		update();
	}

	protected void update() {
		QueryTable q = new QueryTable(tablename);
		rowData = q.getData();
		model = new DefaultTableModel(rowData, colname);
		table.setModel(model);
		table.repaint();
		table.updateUI();
		TableColumn aColumn = table.getColumnModel().getColumn(0);
		aColumn.setCellEditor(table.getDefaultEditor(Boolean.class));
		aColumn.setCellRenderer(table.getDefaultRenderer(Boolean.class));
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
