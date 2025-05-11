package toc.homework.Inheritance2.ex1;

public class MovableRectangle extends Shape implements Movable {
    private int width, height;

    public MovableRectangle(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }
    public void draw() {
        System.out.println("(" + getX() + ", " + getY() + ")" +" / 크기: "+width*height);
    }
    public void move(int dx, int dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }
}
