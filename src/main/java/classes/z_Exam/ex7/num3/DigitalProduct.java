package classes.z_Exam.ex7.num3;

public class DigitalProduct extends Product {

    public DigitalProduct(String name, int basePrice) {
        super(name, basePrice);
    }

    public int getPrice() {
        return (int) (1.1 * getBasePrice());
    }

    public String getInfo() {
        return "상품명: " + getName() + ", 가격: " + getPrice();
    }
}
