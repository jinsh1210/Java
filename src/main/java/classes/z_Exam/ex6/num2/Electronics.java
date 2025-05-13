package classes.z_Exam.ex6.num2;

public class Electronics<T extends Comparable<T>> extends Product<T> implements ComparableItem<Electronics<T>> {

    private T performance;

    public Electronics(String name, T performance) {
        super(name);
        this.performance = performance;
    }

    @Override
    public void describe() {
        System.out.println("제품 이름: " + getName() + ", 성능: " + performance);
    }

    @Override
    public boolean isBetterThan(Electronics<T> other) {
        return this.performance.compareTo(other.performance) > 0;
    }
}

