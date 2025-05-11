package classes.GUI.components.ex1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CheckBoxItemEventEx extends JFrame {
    Container contentPane;
    JCheckBox[] fruits = new JCheckBox[3];
    String[] name = {"사과", "배", "체리"};

    JLabel sumLabel;
    int sum = 0;

    CheckBoxItemEventEx() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("체크박스와 이벤트 예제");
        contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());

        contentPane.add(
                new JLabel("사과 100원 배 500원 체리 20000")
        );
        for(int i = 0; i < fruits.length; i++) {
            fruits[i] = new JCheckBox(name[i]);
            fruits[i].setBorderPainted(true);
            contentPane.add(fruits[i]);
            fruits[i].addItemListener(new MyItemListener());
        }
        sumLabel = new JLabel("현재 0원 입니다.");
        contentPane.add(sumLabel);
        setSize(400,400);
        setVisible(true);

    }
    class MyItemListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            int selected =1;
            if(e.getStateChange() == ItemEvent.SELECTED) {
                selected = 1;
            }
            else selected = -1;
            if(e.getItem() == fruits[0]) {
                sum = sum + selected*100;
            }
            else if(e.getItem() == fruits[1]) {
                sum = sum + selected*500;
            }
            else sum = sum + selected*20000;

            sumLabel.setText("현재"+sum+"원 입니다.");
        }
    }
    public static void main(String [] args) {
        new CheckBoxItemEventEx();
    }
}

