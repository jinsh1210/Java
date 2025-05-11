package classes.GUI.event.ex2;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class EventFrame {

    private JFrame frmEventframe;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EventFrame window = new EventFrame();
                    window.frmEventframe.setLocationRelativeTo(null);
                    window.frmEventframe.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public EventFrame() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmEventframe = new JFrame();
        frmEventframe.setTitle("이벤트 프레임");
        frmEventframe.setBounds(100, 100, 450, 300);
        frmEventframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmEventframe.getContentPane().setLayout(null);

        JButton btnNew = new JButton("New");
        btnNew.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnNew.setBackground(Color.ORANGE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnNew.setBackground(Color.YELLOW);
            }
        });
        btnNew.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnNew.setText("추가");
            }
        });
        btnNew.setFont(new Font("D2Coding", Font.BOLD, 20));
        btnNew.setBounds(38, 31, 112, 49);
        frmEventframe.getContentPane().setLayout(null);
        frmEventframe.getContentPane().add(btnNew);

        JButton btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnExit.setFont(new Font("D2Coding", Font.BOLD, 20));
        btnExit.setBounds(288, 31, 112, 49);
        frmEventframe.getContentPane().add(btnExit);
    }
}

