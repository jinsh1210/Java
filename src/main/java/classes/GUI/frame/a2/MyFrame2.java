package classes.GUI.frame.a2;
import javax.swing.*;

public class MyFrame2 extends JFrame {

    public MyFrame2(String title) {
        setTitle(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);

        setVisible(true);   //무조건 맨 마지막에 둘 것
    }

    public static void main(String[] args) {
        MyFrame2 mf2 = new MyFrame2("내 프레임222");
        mf2.setTitle("MyFrame");
    }
}
