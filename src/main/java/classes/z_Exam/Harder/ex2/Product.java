package classes.z_Exam.Harder.ex2;

public class Product<T>{
    private String name;
    private T value;

    public Product(String name, T value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public T getValue() {
        return value;
    }

    public void displayInfo(){}
}
