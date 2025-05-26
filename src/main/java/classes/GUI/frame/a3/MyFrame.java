package classes.GUI.frame.a3;
import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    public MyFrame(String title) {
        setTitle(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);    //여러 프레임 사용 시 주의
        setSize(350, 150);
        setLocation(1510,0);
//        setLayout(new FlowLayout());
//        setLayout(new BorderLayout());
//        setLayout(new GridLayout(6,1));
        setLayout(null);

        Container c = getContentPane();
        c.setBackground(Color.YELLOW);

        JButton btn1 = new JButton("버튼1");
        btn1.setSize(80,30);
        btn1.setLocation(200,200);

        JButton btn2 = new JButton("버튼2");
        btn2.setBounds(100,100,100,50);

        JButton btn3 = new JButton("버튼3");
        JButton btn4 = new JButton("버튼4");
        JButton btn5 = new JButton("버튼5");
        JButton btn6 = new JButton("버튼6");
        c.add(btn1);
        c.add(btn2);
        c.add(btn3);
        c.add(btn4);
        c.add(btn5);
        c.add(btn6);

        setVisible(true);   //무조건 맨 마지막에 둘 것
    }

    public static void main(String[] args) {
        // MyFrame myFrame = new MyFrame("컴포넌트 추가");

    }
}
