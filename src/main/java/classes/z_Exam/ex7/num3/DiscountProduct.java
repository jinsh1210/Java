package classes.z_Exam.ex7.num3;

public class DiscountProduct extends Product {
    private int discountPercent;

    public DiscountProduct(String name, int basePrice, int discountPercent) {
        super(name, basePrice);
        this.discountPercent = discountPercent;
    }

    public int getPrice() {
        return getBasePrice() - (getBasePrice() * discountPercent/100);
    }

    public String getInfo() {
        return "상품명: " + getName() + ", 할인율: " + discountPercent + "%, 최종가: " + getPrice();
    }
}
