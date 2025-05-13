package classes.z_Exam.Harder.ex2;

public class Phone extends Product<Integer> {
    private String brand;

    public Phone(String name, Integer price, String brand) {
        super(name, price);
        this.brand = brand;
    }

    public void displayInfo() {
        System.out.println("휴대폰 이름: " + getName() + ", 브랜드: " + brand + ", 가격: " + getValue());
    }
}
