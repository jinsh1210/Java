package classes.GUI.app.chat.ex2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame {

	private JFrame frmChatClient;
	private JTextField tfInput;
	private JTextArea taChat;
	private BufferedWriter out;

	public JFrame getfrmChatClient() {
		return frmChatClient;
	}

	public JTextField getTfInput() {
		return tfInput;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatClient chatClient = new ChatClient("");
					chatClient.frmChatClient.setVisible(true);
					new Thread(() -> chatClient.runClient()).start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ChatClient(String title) {
		initialize();
	}

	private void initialize() {
		frmChatClient = new JFrame();
		frmChatClient.setTitle("Chat Client");
		frmChatClient.setBounds(100, 100, 381, 334);
		frmChatClient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 0));
		frmChatClient.getContentPane().add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Chat Client");
		lblNewLabel.setFont(new Font("D2Coding", Font.BOLD, 20));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 255, 255));
		frmChatClient.getContentPane().add(panel_1, BorderLayout.SOUTH);

		tfInput = new JTextField();
		tfInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				typeMsg();
			}
		});
		panel_1.add(tfInput);
		tfInput.setColumns(25);

		JButton buttonSend = new JButton("Send");
		buttonSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = tfInput.getText();
				taChat.append(input + "\n");
				tfInput.setText("");
				tfInput.requestFocus();
			}
		});
		panel_1.add(buttonSend);

		taChat = new JTextArea();
		taChat.setFont(new Font("D2Coding", Font.PLAIN, 16));
		taChat.setEditable(false);
		taChat.setLineWrap(true);
		JScrollPane sp = new JScrollPane(taChat);
		frmChatClient.getContentPane().add(sp, BorderLayout.CENTER);
	}

	public void runClient() {
		Socket socket = null;
		try {
			socket = new Socket("localhost", 9999);

			BufferedReader in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(
					socket.getOutputStream()));
			String inMsg = null;
			while (true) {
				inMsg = in.readLine();
				taChat.append("[서버] : " + inMsg + "\n");
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void typeMsg() {
		try {
			String outMsg = tfInput.getText();
			// #id#1#outMsg#id
			out.write(outMsg + "\n");
			out.flush();
			if (outMsg.equalsIgnoreCase("bye")) {
				this.frmChatClient.dispose();
			}
			tfInput.setText("");
			tfInput.requestFocus();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
