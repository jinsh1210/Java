package toc.gui.ex2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 249, 267);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("성적 입력");
		btnNewButton.addActionListener(e -> {
			RankInputForm inputform = new RankInputForm();
			inputform.setVisible(true);
		});
		btnNewButton.setBounds(67, 31, 117, 62);
		contentPane.add(btnNewButton);

		JButton listbtn = new JButton("성적 조회");
		listbtn.addActionListener(e -> {
			ListForm listform = new ListForm();
			listform.setVisible(true);
		});
		listbtn.setBounds(67, 132, 117, 62);
		contentPane.add(listbtn);
	}
}
