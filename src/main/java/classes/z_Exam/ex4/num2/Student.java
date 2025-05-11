package classes.z_Exam.ex4.num2;

public class Student {
    private String name;
    private int StudentId;
    private String major;

    public Student(String name, int studentId, String major) {
        this.name = name;
        StudentId = studentId;
        this.major = major;
    }

    public void printInfo(){
        System.out.println("이름: "+name+", 학번: "+StudentId+", 전공: "+major);
    }
}
