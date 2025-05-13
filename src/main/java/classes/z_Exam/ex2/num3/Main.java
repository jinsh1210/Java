package classes.z_Exam.ex2.num3;

public class Main {
    public static void main(String[] args) {
        Triple<String, Double, Boolean> triple = new Triple<String, Double, Boolean>("홍길동", 175.2, true);

        System.out.println("이름: " + triple.getFirst());
        System.out.println("키: " + triple.getSecond());
        System.out.println("사실여부: " + triple.getThird());

    }
}
