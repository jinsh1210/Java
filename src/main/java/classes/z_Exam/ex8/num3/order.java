package classes.z_Exam.ex8.num3;

import java.util.LinkedList;
import java.util.Queue;

public class order {
    private Queue<String> o;

    public order() {
        o = new LinkedList<String>();
    }

    public void orders(String order) {
        o.offer(order);
    }

    public void serving() {
        if (o != null && o.size()>0) {
            System.out.println(o.poll() + " 서빙 완료");
        } else {
            System.out.println("모든 메뉴가 서빙 완료!");
        }
    }

    public void orderlist() {
        if (o.isEmpty()) {
            System.out.println("주문하신 메뉴가 없습니다.");
        } else {
            System.out.println("주문 메뉴:");
            for (String os : o) {
                System.out.println(os);
            }
        }
    }
}
