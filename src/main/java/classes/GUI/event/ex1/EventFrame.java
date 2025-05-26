package classes.GUI.event.ex1;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@Getter

public class EventFrame extends JFrame implements ActionListener, MouseListener {

    private JButton button;

    public EventFrame(String title) {
        setTitle(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        button = new JButton("버튼");
        button.addActionListener(this);
        button.addMouseListener(this);
        add(button);

        setVisible(true);   //무조건 맨 마지막에 둘 것
    }

    public static void main(String[] args) {
        // EventFrame frame = new EventFrame("이벤트 프레임");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //문자 내용을 비교할 때 .equals() 사용
        if (button.getText().equals("버튼")) {
            button.setText("Button");
        } else {
            button.setText("버튼");
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // int x = e.getX();
        // int y = e.getY();
//        System.out.println("( " + x + ", " + y+" )");
        System.out.println("IN");
        button.setBackground(Color.red);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("OUT");
        button.setBackground(Color.blue);
    }
}
