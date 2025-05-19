package toc.gui.ex2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class RankInputForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel BorderPanel;
	private JTextField nameField;
	private JTextField idField;
	private JTextField scoreField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RankInputForm frame = new RankInputForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public RankInputForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		BorderPanel = new JPanel();
		BorderPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(BorderPanel);
		BorderPanel.setLayout(new BorderLayout(0, 0));

		JPanel TitlePanel = new JPanel();
		TitlePanel.setBackground(new Color(255, 220, 0));
		BorderPanel.add(TitlePanel, BorderLayout.NORTH);

		JLabel RTitle = new JLabel("성적 입력 폼");
		RTitle.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		TitlePanel.add(RTitle);

		JPanel absolutePanel = new JPanel();
		BorderPanel.add(absolutePanel, BorderLayout.CENTER);
		absolutePanel.setLayout(null);

		JLabel nameLabel = new JLabel("이름");
		nameLabel.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		nameLabel.setBounds(85, 32, 32, 21);
		absolutePanel.add(nameLabel);

		nameField = new JTextField();
		nameField.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		nameField.setBounds(129, 29, 209, 26);
		absolutePanel.add(nameField);
		nameField.setColumns(10);

		JLabel idLabel = new JLabel("학번");
		idLabel.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		idLabel.setBounds(85, 68, 32, 21);
		absolutePanel.add(idLabel);

		idField = new JTextField();
		idField.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		idField.setColumns(10);
		idField.setBounds(129, 65, 209, 26);
		absolutePanel.add(idField);

		JLabel scoreLabel = new JLabel("학점");
		scoreLabel.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		scoreLabel.setBounds(85, 106, 32, 21);
		absolutePanel.add(scoreLabel);

		scoreField = new JTextField();
		scoreField.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		scoreField.setColumns(10);
		scoreField.setBounds(129, 103, 209, 26);
		absolutePanel.add(scoreField);

		JButton scoreBtn = new JButton("성적 추가");
		scoreBtn.addActionListener(e -> {
			DB db = DB.getInstance();
			String name = nameField.getText().trim();
			String studentid = idField.getText().trim();
			String scoreText = scoreField.getText().trim();

			try {
				int score = Integer.parseInt(scoreText);

				boolean success = db.inputStudent(name, score, studentid);

				if (success) {
					JOptionPane.showMessageDialog(null, "입력성공");
					nameField.setText(null);
					idField.setText(null);
					scoreField.setText(null);
				} else {
					JOptionPane.showMessageDialog(null, "입력실패");
				}
			} catch (NumberFormatException ex) {
				System.out.println("학점은 숫자로 입력해주세요.");
			}
		});
		scoreBtn.setBounds(139, 141, 155, 48);
		absolutePanel.add(scoreBtn);
	}
}
