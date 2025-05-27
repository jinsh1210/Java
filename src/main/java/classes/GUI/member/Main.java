package classes.GUI.member;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private MemberShow memberShowWindow;
	private MemberInput memberInputWindow;

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
			if (memberInputWindow == null || !memberInputWindow.isDisplayable()) {
				memberInputWindow = new MemberInput();
				memberInputWindow.setVisible(true);

				// 창이 닫힐 때 변수 초기화
				memberInputWindow.addWindowListener(new java.awt.event.WindowAdapter() {
					@Override
					public void windowClosed(java.awt.event.WindowEvent e) {
						memberInputWindow = null;
					}
				});
			}
		});
		btnInput.setBounds(60, 36, 165, 74);
		contentPane.add(btnInput);

		JButton btnList = new JButton("데이터 확인");
		btnList.addActionListener(e -> {
			if (memberShowWindow == null || !memberShowWindow.isDisplayable()) {
				memberShowWindow = new MemberShow();
				memberShowWindow.setVisible(true);

				// 창이 닫힐 때 변수 초기화
				memberShowWindow.addWindowListener(new java.awt.event.WindowAdapter() {
					@Override
					public void windowClosed(java.awt.event.WindowEvent e) {
						memberShowWindow = null;
					}
				});
			}
		});
		btnList.setBounds(60, 143, 165, 74);
		contentPane.add(btnList);
	}
}
