package classes.teamProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StartScreen extends JFrame {
    public StartScreen() {
        setTitle("");
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // 제목 라벨
        JLabel title = new JLabel("★ Stock Game ★", SwingConstants.CENTER);
        title.setFont(new Font("맑은 고딕", Font.BOLD, 30));
        add(title, BorderLayout.CENTER);

        // 버튼
        JButton startButton = new JButton("Game Start");
        startButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        startButton.setBackground(Color.GREEN);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // 버튼 클릭 이벤트
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // 시작 화면 닫고
                new StockGame(); // 주식 게임 열기
            }
        });

        setLocationRelativeTo(null); // 화면 가운데 정렬
        setVisible(true);
    }

    public static void main(String[] args) {
        new StartScreen();
    }
}
