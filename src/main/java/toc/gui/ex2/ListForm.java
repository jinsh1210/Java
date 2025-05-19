package toc.gui.ex2;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField searchField;
	private JTable table;
	private DefaultTableModel tableModel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListForm frame = new ListForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ListForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel searchLabel = new JLabel("학번 검색 :");
		searchLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		searchLabel.setBounds(39, 22, 86, 16);
		contentPane.add(searchLabel);

		searchField = new JTextField();
		searchField.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		searchField.setBounds(130, 20, 185, 21);
		contentPane.add(searchField);
		searchField.setColumns(10);

		JButton searchBtn = new JButton("검색");
		searchBtn.addActionListener(e -> {
			String inputId = searchField.getText().trim();

		    if (inputId.isEmpty()) {
		        // 전체 데이터 다시 불러오기
		        DB.getInstance().loadTableData(tableModel);
		    } else {
		        // 학번 검색
		        DB.getInstance().searchStudentById(tableModel, inputId);
		    }
		    searchField.setText(null);
		});
		searchBtn.setBounds(318, 17, 91, 29);
		contentPane.add(searchBtn);

		JScrollPane studentList = new JScrollPane();
		studentList.setBounds(9, 55, 432, 207);
		contentPane.add(studentList);

		tableModel = new DefaultTableModel();
		table = new JTable(tableModel);
		studentList.setViewportView(table);
		
		//데이터베이스 불러오기
		DB.getInstance().loadTableData(tableModel);

	}

}
