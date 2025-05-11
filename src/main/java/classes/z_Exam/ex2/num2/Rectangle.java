package classes.z_Exam.ex2.num2;

public class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void getArea() {
        System.out.println(width*height);
    }
}
