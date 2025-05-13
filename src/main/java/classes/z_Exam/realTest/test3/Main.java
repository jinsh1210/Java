package classes.z_Exam.realTest.test3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Notification> arr = new ArrayList<Notification>();

        arr.add(new Notification("홍길동", 20));
        arr.add(new EmailNotification("이몽룡", 50));
        arr.add(new SMSNotification("성춘향", 40));

        for(Notification n : arr) {
            System.out.println("알림 타입: " + n.getType());
            n.send();
            System.out.println("전송 비용: " + n.getCost() + " 원");
        }
    }
}
