package classes.z_Exam.ex3.num3;

public class MutablePair<T> {
    private T value1;
    private T value2;

    public MutablePair(T value1, T value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public T getValue1() {
        return value1;
    }
    public void setValue1(T value1) {
        this.value1 = value1;
    }
    public T getValue2() {
        return value2;
    }
    public void setValue2(T value2) {
        this.value2 = value2;
    }
}
