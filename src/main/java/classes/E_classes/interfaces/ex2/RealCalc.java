package classes.E_classes.interfaces.ex2;

public class RealCalc implements B {

    @Override
    public int sub(int a, int b) {
        return a - b;
    }

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int mul(int a, int b) {
        return a * b;
    }
}
