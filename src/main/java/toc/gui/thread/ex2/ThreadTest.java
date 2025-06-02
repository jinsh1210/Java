package toc.gui.thread.ex2;

public class ThreadTest {
    public static void main(String[] args) {
        MyThread mt = new MyThread();

        mt.start();

        System.out.println("메인 스레드 실행.....");
        for (int i = 0; i < 10; i++) {

            System.out.println("메인 스레드 : " + (i + 1));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
