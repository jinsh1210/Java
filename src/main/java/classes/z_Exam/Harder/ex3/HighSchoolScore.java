package classes.z_Exam.Harder.ex3;

public class HighSchoolScore extends Score<Integer>{
    private String name;
    private int grade;

    public HighSchoolScore(String subject, Integer score, String studentName, int grade) {
        super(subject, score);
        this.name = studentName;
        this.grade = grade;
    }

    public String getStudentName() {
        return name;
    }

    public String getStudentType() {
        return "고등학생";
    }

    public void displayScore() {
        System.out.print("[" + getStudentType() + "]" +" ["+getStudentName()+"]"+" ["+grade+"학년]"+" - "+"["+getSubject()+"]: "+"["+getScore()+"]점");
    }
}
