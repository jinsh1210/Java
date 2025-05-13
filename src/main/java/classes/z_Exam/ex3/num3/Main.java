package classes.z_Exam.ex3.num3;

public class Main {
    public static void main(String[] args) {
        MutablePair<Integer> pair = new MutablePair<Integer>(0,0);

        pair.setValue1(10);
        pair.setValue2(20);
        System.out.println(pair.getValue1() + " " + pair.getValue2());
    }
}
