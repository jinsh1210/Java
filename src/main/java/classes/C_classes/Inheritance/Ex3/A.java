package classes.C_classes.Inheritance.Ex3;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class A {
    private int a;

    public A(int a) {
//        super();
        this.a = a;
        System.out.println("생성자 A");
    }
}
