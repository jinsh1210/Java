package classes.GUI.components.ex1;

import classes.GUI.app.editor.MyEditor;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyChat {

    private JFrame frmMychat;
    private JTextField tfInput;
    private JTextArea taChat;
    private MyEditor myEditor;

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
                    MyChat window = new MyChat("",null);
                    window.frmMychat.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MyChat(String title, MyEditor myEditor) {
        this.myEditor = myEditor;
        initialize();
    }

    private void initialize() {
        frmMychat = new JFrame();
        frmMychat.setTitle("MyChat");
        frmMychat.setBounds(100, 100, 381, 334);
        frmMychat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 0));
        frmMychat.getContentPane().add(panel, BorderLayout.NORTH);

        JLabel lblNewLabel = new JLabel("MyChat");
        lblNewLabel.setFont(new Font("D2Coding", Font.BOLD, 20));
        panel.add(lblNewLabel);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(0, 255, 255));
        frmMychat.getContentPane().add(panel_1, BorderLayout.SOUTH);

        tfInput = new JTextField();
        tfInput.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendMsg();
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

    private void sendMsg() {
        String input = tfInput.getText();
        taChat.append("[msg] : " + input + "\n");
        tfInput.setText("");
        tfInput.requestFocus();

        myEditor.getTaEditor().append("[msg] : " + input + "\n");
    }
}
