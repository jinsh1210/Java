package toc.gui.ex4;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class BasicForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private InputForm form;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BasicForm frame = new BasicForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BasicForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 647, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnCall = new JButton("폼 호출");
		btnCall.addActionListener(e -> {
			// Singleton
			if (form == null) {
				form = new InputForm();
				form.setVisible(true);
			} else {
				form.setVisible(true);
			}
		});
		btnCall.setBounds(225, 124, 188, 88);
		contentPane.add(btnCall);
	}

}
