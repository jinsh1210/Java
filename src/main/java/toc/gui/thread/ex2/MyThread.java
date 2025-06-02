package toc.gui.thread.ex2;

public class MyThread extends Thread {
    
    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {

            System.out.println("My Thread : " + (i + 1));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
