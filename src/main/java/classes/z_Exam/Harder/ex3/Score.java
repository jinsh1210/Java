package classes.z_Exam.Harder.ex3;

public abstract class Score <T>{
    private String subject;
    private T score;

    public Score(String subject, T score) {
        this.subject = subject;
        this.score = score;
    }

    public String getSubject() {
        return subject;
    }

    public T getScore() {
        return score;
    }

    public abstract void displayScore();
    public abstract String getStudentName();
    public abstract String getStudentType();
}
