package classes.z_Exam.realTest.test3;

public class SMSNotification extends Notification {

    public SMSNotification(String recipient, int messageLength) {
        super(recipient, messageLength);
    }

    public void send() {
        System.out.println("문자로 " + getRecipient() + "에게 알림을 전송합니다.");
    }

    public String getType() {
        return "문자 알림";
    }

    public int getCost() {
        return getMessageLength() * 5;
    }
}
