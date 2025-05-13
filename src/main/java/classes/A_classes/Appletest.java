package classes.A_classes;

public class Appletest {
    public static void main(String[] args) {
        Apple apple1 = new Apple();
        apple1.setBrix(10.2);
        apple1.setTaste("달다");
        apple1.setPrice(1000);

        Apple apple2 = new Apple();
        apple2.setBrix(5.2);
        apple2.setTaste("맛없어");
        apple2.setPrice(600);

        System.out.println(apple1);
        System.out.println(apple2);

        int total = apple1.getPrice() + apple2.getPrice();
        System.out.println("총 금액 : " + total);

    }
}
