package classes.z_Exam.ex7.num1;

public class Product {
    private String name;
    private int price;
    private double taxRate;

    public Product(String name, int price, double taxRate) {
        this.name = name;
        this.price = price;
        this.taxRate = taxRate;
    }

    public double getFinalPrice() {
        return price + price * taxRate/100;
    }

    public void printReceipt() {
        System.out.println("상품: " + name + " / 정가: " + price + " / 세금 포함: " + getFinalPrice());
    }
}
