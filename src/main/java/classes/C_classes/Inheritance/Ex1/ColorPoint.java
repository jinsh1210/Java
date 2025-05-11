package classes.C_classes.Inheritance.Ex1;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@ToString
public class ColorPoint extends Point {

    private String color;

    public ColorPoint(int x, int y, String color) {
        super(x, y);
        this.color = color;
    }

    @Override
    public String toString() {
        return "ColorPoint " + "color = " + color + " " + super.toString();
    }


}
