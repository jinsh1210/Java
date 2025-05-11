package classes.z_Exam.realTest.test2;

public class EmailNotification extends Notification {
    public EmailNotification(String recipient, int messageLength) {
        super(recipient, messageLength);
    }

    public void send(){
        System.out.println("이메일로 "+getRecipient()+"에게 알림을 전송합니다.");
    }
    public String getType(){
        return "이메일 알림";
    }
    public int getCost(){
        return 100;
    }
}
