package toc.homework.Inheritance.ex4;

public class Rectangle extends Shape {
    private int width;
    private int heigh;

    public Rectangle(int width, int heigh) {
        this.width = width;
        this.heigh = heigh;
    }

    @Override
    public double getArea(){
        return width * heigh;
    }
}
