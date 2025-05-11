package classes.z_Exam.ex5.num2;

import java.util.LinkedList;

public class StudentManager {
    private LinkedList<String> students;

    public StudentManager() {
        students = new LinkedList();
    }

    public void addStudent(String name) {
        students.add(name);
    }

    public void removeStudent(String name) {
        if (students.remove(name)) {
            System.out.println(name + " 삭제");
        } else {
            System.out.println(name + "은 없습니다.");
        }
    }

    public void printStudents() {
        System.out.println("학생 명단: ");
        for (String name : students) {
            System.out.println(name);
        }
    }
}
