package classes.z_Exam.ex8.num1;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Contact> ct = new LinkedList<>();

        ct.add(new Contact("진승현","010-2172-9446"));
        ct.add(new Contact("홍길동","010-1234-9446"));
        ct.add(new Contact("손흥민","010-4321-9446"));
        for (Contact c : ct) {
            System.out.println(c.toString());
        }
    }
}
