package toc.homework.Inheritance.ex1;

public class Student extends Person {
    private String major;

    public Student(String name, int age, String major) {
        super(name, age);
        this.major = major;
    }

    public void introduce() {
        System.out.println("이름: "+ this.getName() + ", 나이: " + this.getAge() + ", 전공: " + this.major);
    }
}
