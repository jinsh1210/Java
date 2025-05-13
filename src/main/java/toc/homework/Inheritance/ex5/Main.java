package toc.homework.Inheritance.ex5;

public class Main {
    public static void main(String[] args) {
        Employee[] e = new Employee[4];
        e[0] = new Manager("김부장",300);
        e[1] = new Developer("이개발",300);
        e[2] = new Manager("홍길동",400);
        e[3] = new Developer("손흥민",400);

        for (int i = 0; i < 4; i++) {
            e[i].printInfo();
        }
    }
}
