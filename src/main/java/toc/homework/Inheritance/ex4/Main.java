package toc.homework.Inheritance.ex4;

public class Main {
    public static void main(String[] args) {
        Shape c = new Circle(5.0);
        Shape r = new Rectangle(4,6);

        c.printArea();
        r.printArea();
    }
}
