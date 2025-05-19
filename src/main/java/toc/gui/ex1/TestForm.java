package toc.gui.ex1;

import javax.swing.*;
import java.awt.*;

public class TestForm extends JFrame {
    private JTextField textField;

    public TestForm() {
        setTitle("Test Form");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // 패널 생성 및 레이아웃 설정
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // 텍스트 필드 생성
        textField = new JTextField();
        textField.setMaximumSize(new Dimension(250, 30));
        textField.setAlignmentX(Component.CENTER_ALIGNMENT);

        // 패널에 텍스트 필드 추가
        panel.add(textField);

        // 프레임에 패널 추가
        add(panel);
    }
}