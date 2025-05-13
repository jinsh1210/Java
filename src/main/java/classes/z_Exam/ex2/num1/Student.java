package classes.z_Exam.ex2.num1;

public class Student {
    private String name;
    private int StudentId;
    private String major;

    public Student(String name, int studentId, String major) {
        this.name = name;
        StudentId = studentId;
        this.major = major;
    }

    public void introduce() {
        System.out.println("이름: " + name + ", 학번: " + StudentId + ", 전공: " + major);
    }
}
