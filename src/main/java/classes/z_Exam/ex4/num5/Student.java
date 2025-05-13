package classes.z_Exam.ex4.num5;

public class Student<T>{
    private String name;
    private T score;

    public Student(String name, T score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public T getScore() {
        return score;
    }
}
