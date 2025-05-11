package classes.D_classes.override.Ex2;

public class Main {

    public static void main(String[] args) {
        Shape shape = new Shape();
        shape.draw();

        shape = new Rect();
        shape.draw();

        shape = new Circle();
        shape.draw();

        shape = new Line();
        shape.draw();

    }
}
