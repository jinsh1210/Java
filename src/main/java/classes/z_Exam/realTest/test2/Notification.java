package classes.z_Exam.realTest.test2;

public class Notification {
    private String recipient;
    private int messageLength;

    public String getRecipient() {
        return recipient;
    }

    public int getMessageLength() {
        return messageLength;
    }

    public Notification(String recipient, int messageLength) {
        this.recipient = recipient;
        this.messageLength = messageLength;
    }

    public void send(){
        System.out.println("기본 알림을 전송합니다.");
    }
    public String getType(){
        return "일반 알림";
    }
    public int getCost(){
        return 0;
    }

}
