package classes.B_classes;

public class B extends A {
    private int b;

    public B(int a, int b) {
        super(a);
        this.b = b;
        System.out.println("생성자 B");
    }
}
