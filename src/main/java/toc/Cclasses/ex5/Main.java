package toc.Cclasses.ex5;

public class Main {
    public static void main(String[] args) {
        Employee m = new Manager("김부장",300);
        Employee d = new Developer("이개발",300);

        m.printInfo();
        d.printInfo();
    }
}
