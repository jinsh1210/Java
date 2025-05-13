package classes.z_Exam.ex7.num3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Vector<Product> p = new Vector<>();
        //ArrayList<Product> p = new ArrayList<>();
        //Stack<Product> p = new Stack<>();

        p.add(new Product("일반 상품", 10000));
        p.add(new DigitalProduct("디지털 상품", 20000));
        p.add(new DiscountProduct("할인 상품", 30000, 20));

        for (Product p1 : p) {
            System.out.println(p1.getInfo());
            System.out.println("가격: " + p1.getPrice());
        }

    }
}
