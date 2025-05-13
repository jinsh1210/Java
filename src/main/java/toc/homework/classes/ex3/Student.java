package toc.homework.classes.ex3;

public class Student {
    private String name;
    private int score1, score2, score3;

    public Student(String name, int score1, int score2, int score3) {
        this.name = name;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
    }

    public double getAverage() {
        return (score1 + score2 + score3) / 3;
    }

    public boolean isPass() {

        if (getAverage() >= 60) {
            return true;
        } else {
            return false;
        }
    }

    public String getInfo(){
        if (isPass()) {
            return "이름: "+name+", 평균: "+getAverage()+", 합격 여부: 합격";
        }
        else{
            return "이름: "+name+", 평균: "+getAverage()+", 합격 여부: 불합격";
        }
    }
}


