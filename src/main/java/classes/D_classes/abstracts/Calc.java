package classes.D_classes.abstracts;

public abstract class Calc {
    private int result;

    public int add(int a, int b) {
        result = a + b;
        return result;
    }

    public abstract int sub(int a, int b);
}
