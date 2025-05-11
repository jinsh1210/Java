package classes.z_Exam.ex7.num3;

public class Product {
    private String name;
    private int basePrice;

    public Product(String name, int basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    public String getName() {
        return name;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public int getPrice() {
        return basePrice;
    }

    public String getInfo() {
        return "상품명: " + name + ", 가격: " + basePrice;
    }

}
