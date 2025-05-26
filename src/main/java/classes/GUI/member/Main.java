package classes.GUI.member;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {

		// DB 연결
		DB.init();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 286, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnInput = new JButton("데이터 입력");
		btnInput.addActionListener(e -> {
			MemberInput mi = new MemberInput();
			mi.setVisible(true);
		});
		btnInput.setBounds(60, 36, 165, 74);
		contentPane.add(btnInput);

		JButton btnList = new JButton("데이터 확인");
		btnList.addActionListener(e -> {
			MemberShow ms = new MemberShow();
			ms.setVisible(true);
		});
		btnList.setBounds(60, 143, 165, 74);
		contentPane.add(btnList);
	}
}
