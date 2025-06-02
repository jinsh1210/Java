package toc.gui.thread.ex1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class TimerForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lbTimer;
	private TimerThread tt;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimerForm frame = new TimerForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TimerForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lbTimer = new JLabel("0");
		lbTimer.setHorizontalAlignment(SwingConstants.CENTER);
		lbTimer.setFont(new Font("Lucida Grande", Font.BOLD, 99));
		lbTimer.setBounds(85, 0, 278, 212);
		contentPane.add(lbTimer);

		JButton btnStart = new JButton("Start");
		btnStart.setBounds(81, 206, 141, 45);
		contentPane.add(btnStart);

		JButton btnStop = new JButton("Stop");
		btnStop.setBounds(234, 206, 141, 45);
		contentPane.add(btnStop);

		// Button Action
		btnStart.addActionListener(e -> {
			tt = new TimerThread(lbTimer);
			tt.start();
		});
		btnStop.addActionListener(e -> {
			tt.interrupt();
		});
	}
}
