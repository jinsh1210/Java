package classes.z_Exam.realTest.test2;

public class Main {
    public static void main(String[] args) {

        Notification[] arr = new Notification[3];

        arr[0] = new Notification("홍길동", 20);
        arr[1] = new EmailNotification("이몽룡", 50);
        arr[2] = new SMSNotification("성춘향", 40);

        for (Notification n : arr) {
            System.out.println("알림 타입: " + n.getType());
            n.send();
            System.out.println("전송 비용: " + n.getCost() + " 원");
        }
    }
}
