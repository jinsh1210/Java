package classes.z_Exam.ex8.num4;

import java.util.Vector;

public class Score {
    private Vector<Integer> s;

    public Score() {
        s = new Vector<>();
    }

    public void getScore(int score) {
        s.add(score);
    }

    public void removeScore(int score) {
        s.remove(score);
    }

    public void show(){
        if(s.isEmpty()){
            System.out.println("점수를 입력해주세요.");
        } else {
            for(Integer i : s){
                System.out.println(i + " ");
            }
            System.out.println();
        }
    }

    public void avg() {
        if(s.isEmpty()){
            System.out.println("평균 낼 점수가 없습니다.");
        } else {
            int sum = 0;
            for(Integer i : s){
                sum += i;
            }
            int avg = sum / s.size();
            System.out.println("평균: " + avg);
        }
    }
}
