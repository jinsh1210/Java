package classes.z_Exam.ex5.num5;

public class Main {
    public static void main(String[] args) {
        StudentManager stdM = new StudentManager();

        stdM.addStudent("지민");
        stdM.addStudent("태형");
        stdM.addStudent("정국");
        stdM.printStudents();
        System.out.println();
        stdM.removeStudent("태형");
        stdM.removeStudent("윤기");
        stdM.printStudents();
    }
}
