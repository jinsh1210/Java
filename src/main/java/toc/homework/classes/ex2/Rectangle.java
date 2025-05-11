package toc.homework.classes.ex2;

public class Rectangle {
    private int width, height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    int getArea(){
        return width * height;
    }

    int getPerimeter(){
        return 2 * (width + height);
    }
}
