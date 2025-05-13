package classes.GUI.event.ex3;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MouseEvent {

    private JFrame frame;
    private JLabel lblName;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MouseEvent window = new MouseEvent();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public MouseEvent() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                System.out.println(x + ", " + y);
                lblName.setLocation(x, y);

            }
        });
        frame.setTitle("마우스 키보드 이벤트 ver.1");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        lblName = new JLabel("홍길동");
        lblName.setFont(new Font("D2Coding", Font.PLAIN, 20));
        lblName.setBounds(33, 63, 60, 30);
        frame.getContentPane().add(lblName);
    }

}

