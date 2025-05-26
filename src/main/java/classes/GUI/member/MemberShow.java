package classes.GUI.member;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MemberShow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private DefaultTableModel tableModel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberShow frame = new MemberShow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MemberShow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel nameLabel = new JLabel("이름 검색: ");
		nameLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		nameLabel.setBounds(25, 12, 82, 16);
		contentPane.add(nameLabel);

		textField = new JTextField();
		textField.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		textField.setBounds(115, 7, 208, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton searchBtn = new JButton("검색");
		searchBtn.addActionListener(e -> {
			
		});
		searchBtn.setBounds(327, 6, 102, 29);
		contentPane.add(searchBtn);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 45, 404, 205);
		contentPane.add(scrollPane);

		tableModel = new DefaultTableModel();
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);

		loadTableData();
	}

	private void loadTableData() {
		String[] colNames = { "ID", "이름", "나이", "키" };
		tableModel.setColumnIdentifiers(colNames);
	}
}
