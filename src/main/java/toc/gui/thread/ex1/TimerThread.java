package toc.gui.thread.ex1;

import javax.swing.JLabel;

public class TimerThread extends Thread {

    private JLabel lbTimer;

    public TimerThread(JLabel lbTimer) {
        this.lbTimer = lbTimer;
    }

    @Override
    public void run() {
        int n = 0;
        while (true) {
            lbTimer.setText(n + "");
            n++;

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
