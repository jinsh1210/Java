package classes.z_Exam.ex7.num2;

public class Main {
    public static void main(String[] args) {
        Product[] p = new Product[3];
        p[0] = new Product("일반 상품", 10000);
        p[1] = new DigitalProduct("디지털 상품", 20000);
        p[2] = new DiscountProduct("할인 상품", 30000, 20);


        for (int i = 0; i < p.length; i++) {
            System.out.println(p[i].getInfo());
            System.out.println("가격: " + p[i].getPrice());
            System.out.println();
        }
    }
}
