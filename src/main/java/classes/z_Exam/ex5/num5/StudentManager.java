package classes.z_Exam.ex5.num5;

import java.util.LinkedList;

public class StudentManager {
    private LinkedList<String> students;

    public StudentManager() {
        students = new LinkedList<>();
    }

    void addStudent(String name) {
        students.add(name);
    }

    void removeStudent(String name) {
        if (students.contains(name)) {
            students.remove(name);
            System.out.println("[" + name + "]" + " 명단에서 삭제");
        } else {
            System.out.println("[" + name + "]" + " 명단에 없음");
        }
    }

    void printStudents() {
        System.out.println("현재 학생 명단: ");
        for (String name : students) {
            System.out.println("["+name+"]");
        }
    }
}
