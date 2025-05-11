package toc.homework.Inheritance2.ex1;

public class Main {
    public static void main(String[] args) {
        MovableRectangle m = new MovableRectangle(1,2,3,4);
        m.draw();
        m.move(5,5);
        m.draw();
    }
}
