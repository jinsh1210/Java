package classes.z_Exam.ex8.num4;

public class Main {
    public static void main(String[] args) {
        Score s = new Score();

        s.getScore(80);
        s.getScore(90);
        s.getScore(75);
        s.getScore(95);
        s.getScore(85);

        s.show();
        s.avg();

        s.removeScore(80);
        s.show();
        s.avg();

    }
}
