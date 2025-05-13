package classes.D_classes.homework;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Main {

    public static void main(String[] args) {
        Shape start, n, obj;

        start = new Line();     // Line 객체 연결
        n = start;
        obj = new Rect();
        n.setNext(obj);         // Rect 객체 연결
        n = obj;
        obj = new Line();       // Line 객체 연결
        n.setNext(obj);
        n = obj;
        obj = new Circle();     // Circle 객체 연결
        n.setNext(obj);

        while (start != null) {
            start.draw();
            start = start.getNext();
        }
    }
}
