package classes.z_Exam.ex4.num4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static double calculateAverage(List<StudentScore> list) {
        if (list.isEmpty()) return 0;

        int sum = 0;
        for (StudentScore s : list) {
            sum += s.getScore();
        }
        return (double) sum / list.size();
    }

    public static void main(String[] args) {

        List<StudentScore> students = new ArrayList<>();

        students.add(new StudentScore("홍길동", 52));
        students.add(new StudentScore("손흥민", 83));
        students.add(new StudentScore("박지성", 91));

        double avg = calculateAverage(students);
        System.out.println("평균 점수: " + avg);
    }
}
