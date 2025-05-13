package classes.D_classes.homework;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Shape {
    private Shape next;                 //필드 private 사용

/*    public Shape getNext() {            //Getter
        return next;
    }
    public void setNext(Shape next) {   //Setter
        this.next = next;
    }*/

    public void draw() {
        System.out.println("Drawing Shape");
    }
}
