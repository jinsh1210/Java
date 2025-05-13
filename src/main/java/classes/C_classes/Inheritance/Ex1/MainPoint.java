package classes.C_classes.Inheritance.Ex1;

public class MainPoint {
    public static void main(String[] args) {
        Point p = new Point(10,20);
        p.setX(10);
        p.setY(20);
        System.out.println(p.toString());

        ColorPoint cp = new ColorPoint(100,200,"RED");
        cp.setX(100);
        cp.setY(200);
        cp.setColor("RED");
        System.out.println(cp);

    }
}
