package classes.GUI.event.ex4;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MouseEvent {

    private JFrame frame;
    private JLabel lblName;
    private final int STEP = 30;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MouseEvent window = new MouseEvent();
                    window.frame.setLocationRelativeTo(null);
                    window.frame.getContentPane().setFocusable(true);
                    window.frame.getContentPane().requestFocus();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }

    public MouseEvent() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char keyChar = e.getKeyChar();
                int keyCode = e.getKeyCode();
                System.out.println(keyChar + ", " + keyCode);

                if (keyCode == KeyEvent.VK_RIGHT) {
                    lblName.setLocation(lblName.getX() + STEP, lblName.getY());
                } else if (keyCode == KeyEvent.VK_LEFT) {
                    lblName.setLocation(lblName.getX() - STEP, lblName.getY());
                } else if (keyCode == KeyEvent.VK_UP) {
                    lblName.setLocation(lblName.getX(), lblName.getY() - STEP);
                } else if (keyCode == KeyEvent.VK_DOWN) {
                    lblName.setLocation(lblName.getX(), lblName.getY() + STEP);
                }
            }
        });

        frame.getContentPane().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                lblName.setLocation(e.getPoint());
            }
        });

        frame.setTitle("마우스 키보드 이벤트 ver.0.1");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        lblName = new JLabel("홍길동");
        lblName.setFont(new Font("D2Coding", Font.PLAIN, 20));
        lblName.setBounds(67, 110, 60, 30);
        frame.getContentPane().add(lblName);
    }


}

