package toc.homework.classes.ex4;

public class Main {
    public static void main(String[] args) {
        String[] names = {"철수", "영희", "민수", "지혜"};
        int[] scores = {75, 82, 91, 68};
        Classroom cls = new Classroom(names, scores);
        System.out.println("평균 점수: " + cls.getAverageScore());
        System.out.println();
        System.out.println("최고 점수 학생: " + cls.getTopStudent());
        System.out.println();
        System.out.println(cls.getAllStudentInfo());
    }
}
