package classes.GUI.member;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;

public class MemberInput extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nameField;
	private JTextField ageField;
	private JTextField heightField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberInput frame = new MemberInput();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MemberInput() {
		setTitle("사용자 입력 폼");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 429, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel nameLabel = new JLabel("이름:");
		nameLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		nameLabel.setBounds(71, 39, 43, 16);
		contentPane.add(nameLabel);

		nameField = new JTextField();
		nameField.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		nameField.setBounds(126, 34, 219, 26);
		contentPane.add(nameField);
		nameField.setColumns(10);

		JLabel ageLabel = new JLabel("나이:");
		ageLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		ageLabel.setBounds(71, 84, 43, 16);
		contentPane.add(ageLabel);

		ageField = new JTextField();
		ageField.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		ageField.setColumns(10);
		ageField.setBounds(126, 79, 219, 26);
		contentPane.add(ageField);

		JLabel heightLabel = new JLabel("키:");
		heightLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		heightLabel.setBounds(87, 130, 43, 16);
		contentPane.add(heightLabel);

		heightField = new JTextField();
		heightField.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		heightField.setColumns(10);
		heightField.setBounds(126, 125, 219, 26);
		contentPane.add(heightField);

		JButton btnInput = new JButton("입력");
		btnInput.addActionListener(e -> {
			String insertSql = "INSERT INTO member (name, age, height) VALUES (?, ?, ?)";
			
			String name = nameField.getText();
			int age = Integer.parseInt(ageField.getText());
			double height = Double.parseDouble(heightField.getText());
			
			int res = DB.excuteUpdate(insertSql, name, age, height);
			
			if(res >0) {
				JOptionPane.showMessageDialog(null, "입력 성공");
			} else {
				JOptionPane.showMessageDialog(null, "입력 실패");
			}
		});

		btnInput.setBounds(138, 178, 147, 56);
		contentPane.add(btnInput);
	}
}
