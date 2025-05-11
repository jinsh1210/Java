package classes.z_Exam.ex8.num3;

public class Main {
    public static void main(String[] args) {
        order q = new order();

        q.orders("김밥");
        q.orders("떡볶이");
        q.orders("순대");

        q.orderlist();
        q.serving();
        q.orderlist();
        q.serving();
        q.serving();
        q.serving();
        q.orderlist();

    }
}
