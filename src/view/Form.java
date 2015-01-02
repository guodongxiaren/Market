package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import db.Update;
import db.QueryTable;

@SuppressWarnings("serial")
public abstract class Form extends JPanel {

	private JButton jbAdd, jbDel, jbUpd;
	private JTable table;
	private TableModel model;
	// 放置按钮的面板
	private JPanel phead = new JPanel(new FlowLayout(FlowLayout.LEFT));
	// 滚动面板
	private JScrollPane sp;
	protected Vector<Vector<Object>> rowData;
	private Vector<String> colname;
	private String tablename;
	private JLabel titleLabel;

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
		// 按钮
		jbAdd = new JButton("增加");
		jbDel = new JButton("删除");
		jbUpd = new JButton("更新");

		jbAdd.addActionListener(createListener);
		jbDel.addActionListener(deleteListener);
		jbUpd.addActionListener(updateListener);

		phead.add(jbAdd);
		phead.add(jbDel);
		phead.add(jbUpd);

		JPanel ptitle = new JPanel(new BorderLayout());
		titleLabel = new JLabel();
		titleLabel.setFont(new Font("΢���ź�",Font.BOLD,15));
		JPanel p = new JPanel();

		p.add(titleLabel);
		ptitle.add(p, BorderLayout.NORTH);
		ptitle.add(phead, BorderLayout.CENTER);
		add(ptitle, BorderLayout.NORTH);
		add(sp, BorderLayout.CENTER);
	}

	public void setTitle(String title) {
		titleLabel.setText(title);
	}

	protected abstract void create();

	protected void setColName(String[] fields) {
		colname.clear();
		colname.addElement("选中");
		for (int i = 0; i < fields.length; i++) {
			colname.addElement(fields[i]);
		}
		update();
	}

	protected void delete() {
		TableModel tm = table.getModel();
		for (int i = 0; i < rowData.size(); i++) {
			boolean b = (boolean) tm.getValueAt(i, 0);
			if (b == true) {
				int id = Integer.parseInt((String) tm.getValueAt(i, 1));
				Update.delete(id, tablename);
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


	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public TableModel getModel() {
		return model;
	}

	public void setModel(TableModel model) {
		this.model = model;
	}

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

@SuppressWarnings("serial")
abstract class SingleForm extends JDialog implements ActionListener {
	private int count;
	@SuppressWarnings("unused")
	private String[] fields;
	private JTextField[] textField;
	private JButton jbok;
	protected JPanel pUp, pDown, pLeft, pRight;

	public SingleForm(String[] fields) {
		this.fields = fields;
		count = fields.length;
		setLayout(new BorderLayout());
		setSize(300, 40 * (count + 1));

		pUp = new JPanel(new BorderLayout());
		pUp.setBorder(new EmptyBorder(10, 50, 10, 30));
		pDown = new JPanel();

		pLeft = new JPanel(new GridLayout(count, 2, 5, 5));
		pRight = new JPanel(new GridLayout(count, 2, 5, 5));
		pUp.add(pLeft, BorderLayout.CENTER);
		pUp.add(pRight, BorderLayout.EAST);
		for (int i = 0; i < count; i++) {
			JLabel label = new JLabel(fields[i]);
			pLeft.add(label);
		}

		jbok = new JButton("确定");
		jbok.addActionListener(this);
		pDown.add(jbok);
		add(pUp, BorderLayout.CENTER);
		add(pDown, BorderLayout.SOUTH);

		initUI();
		setModal(true);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	protected String[] getInput(){
		String[] input = new String[count];
		for(int i=0;i<count;i++){
			input[i] = textField[i].getText();
		}
		return input;
	}
	protected void clearInput(){
		for(int i=0;i<count;i++){
			textField[i].setText("");
		}
	}
	protected void initUI() {
		textField = new JTextField[count];
		for (int i = 0; i < count; i++) {
			textField[i] = new JTextField(20);
			pRight.add(textField[i]);
		}
	}

	protected final JPanel getRightPanel() {
		return pRight;
	}
}
