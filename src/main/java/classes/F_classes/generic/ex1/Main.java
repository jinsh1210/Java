package classes.F_classes.generic.ex1;

public class Main {
    public static void main(String[] args) {

        MyClass<String> c1 = new MyClass<>();
        c1.getVal();
        c1.setVal("");

        MyClass<Integer> c2 = new MyClass<>();
        c2.getVal();
        c2.setVal(1);
    }
}
