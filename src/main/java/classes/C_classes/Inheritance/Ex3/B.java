package classes.C_classes.Inheritance.Ex3;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class B extends A {

    private int b;

    public B(int a, int b) {
        super(a);
        this.b = b;
        System.out.println("생성자 B");
    }

}
