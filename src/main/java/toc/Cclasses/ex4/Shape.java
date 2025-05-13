package toc.Cclasses.ex4;

public abstract class Shape {

    public abstract double getArea();

    public void printArea() {
        System.out.println("넓이: " + getArea());
    }
}
