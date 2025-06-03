package classes.GUI.app.chat.ex1;

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
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatServer extends JFrame {

	private JFrame frmMychat;
	private JTextField tfInput;
	private JTextArea taChat;
	private BufferedWriter out;

	public JFrame getFrmMychat() {
		return frmMychat;
	}

	public JTextField getTfInput() {
		return tfInput;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatServer chatServer = new ChatServer();
					chatServer.frmMychat.setVisible(true);
					new Thread(() -> chatServer.runServer()).start();
//					chatServer.runServer();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ChatServer() {
		initialize();
	}

	private void initialize() {
		frmMychat = new JFrame();
		frmMychat.setTitle("Chat Server");
		frmMychat.setBounds(100, 100, 381, 334);
		frmMychat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 0));
		frmMychat.getContentPane().add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Chat Server");
		lblNewLabel.setFont(new Font("D2Coding", Font.BOLD, 20));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 255, 255));
		frmMychat.getContentPane().add(panel_1, BorderLayout.SOUTH);

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
		frmMychat.getContentPane().add(sp, BorderLayout.CENTER);
	}

	public void runServer() {
		ServerSocket server = null;
		try {
			server = new ServerSocket(9999);
			taChat.append("서버가 시작되었습니다.\n");

			Socket socket = server.accept();
			taChat.append("클라이언트가 접속했습니다.\n");

			BufferedReader in = new BufferedReader(new InputStreamReader(
				socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(
				socket.getOutputStream()));

			String inMsg = null;
			while (true) {
				inMsg = in.readLine();
				taChat.append("[클라이언트] : " + inMsg + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (server != null)
				try {
					server.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	private void typeMsg() {
		try {
			String outMsg = tfInput.getText();
			out.write(outMsg + "\n");
			out.flush();
			taChat.append("[서버] : " + outMsg + "\n");
			tfInput.setText("");
			tfInput.requestFocus();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
