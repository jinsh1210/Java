package classes.z_Exam.Harder.ex3;

public class MiddleSchoolScore extends Score<Integer> {
    private String name;
    private int grade;

    public MiddleSchoolScore(String subject, Integer score, String studentName, int grade) {
        super(subject, score);
        this.name = studentName;
        this.grade = grade;
    }

    public String getStudentName() {
        return name;
    }

    public String getStudentType() {
        return "중학생";
    }

    public void displayScore() {
        System.out.print("[" + getStudentType() + "]" +" ["+getStudentName()+"]"+" ["+grade+"학년]"+" - "+"["+getSubject()+"]: "+"["+getScore()+"]점");
    }

}
