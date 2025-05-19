package toc.gui.ex1;

import javax.swing.*;
import java.awt.*;

public class MyForm extends JFrame {
    public MyForm() {
        setTitle("메인 폼");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 패널 생성 및 레이아웃 설정
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // 버튼 생성
        JButton button1 = new JButton("TestForm 열기");
        JButton button2 = new JButton("버튼 2");

        // 버튼 크기 설정
        Dimension buttonSize = new Dimension(150, 40);
        button1.setMaximumSize(buttonSize);
        button2.setMaximumSize(buttonSize);

        // 버튼 정렬
        button1.setAlignmentX(Component.CENTER_ALIGNMENT);
        button2.setAlignmentX(Component.CENTER_ALIGNMENT);

        // 버튼1 클릭 이벤트
        button1.addActionListener(e -> {
            TestForm testForm = new TestForm();
            testForm.setVisible(true);
        });

        // 패널에 버튼 추가
        panel.add(button1);
        panel.add(Box.createVerticalStrut(10)); // 버튼 사이 간격
        panel.add(button2);

        // 프레임에 패널 추가
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MyForm form = new MyForm();
            form.setVisible(true);
        });
    }
}