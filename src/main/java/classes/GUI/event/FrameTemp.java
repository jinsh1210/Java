package classes.GUI.event;
import javax.swing.*;

public class FrameTemp extends JFrame {

    public FrameTemp(String title) {
        setTitle(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);

        setVisible(true);   //무조건 맨 마지막에 둘 것
    }

    public static void main(String[] args) {
        // FrameTemp frame = new FrameTemp("Temp Frame");
    }
}
