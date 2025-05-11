package classes.z_Exam.ex6.num2;

public abstract class Product <T> {
    private String name;

    public String getName() {
        return name;
    }

    public Product(String name) {
        this.name = name;
    }

    public abstract void describe();
}
