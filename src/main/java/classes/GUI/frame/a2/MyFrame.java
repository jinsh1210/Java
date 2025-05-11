package classes.GUI.frame.a2;

import javax.swing.*;

public class MyFrame {
    public static void main(String[] args) {
        JFrame f = new JFrame();

        f.setTitle("My Frame");
        f.setSize(300, 300);
        //f.setLocation(800,500); //잘 안씀
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);
    }
}
