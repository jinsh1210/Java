package classes.z_Exam.Harder.ex3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Score<Integer>> students = new ArrayList<>();

        students.add(new MiddleSchoolScore("체육",89,"중1",1));
        students.add(new MiddleSchoolScore("체육",92,"중2",2));
        students.add(new HighSchoolScore("미술",56,"고1",1));
        students.add(new HighSchoolScore("미술",91,"고2",2));

        for(Score<Integer> score : students){
            if(score.getStudentType().equals("중학생") && score.getScore()>=90 ){
                score.displayScore();
                System.out.println(" / 우수 중학생");
            } else if(score.getStudentType().equals("중학생") && score.getScore()<90){
                score.displayScore();
                System.out.println();
            }

            if (score.getStudentType().equals("고등학생") && score.getScore()<60){
                score.displayScore();
                System.out.println(" / 재시험 대상");
            } else if(score.getStudentType().equals("고등학생") && score.getScore()>=60){
                score.displayScore();
                System.out.println();
            }
        }
    }
}