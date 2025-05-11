package classes.z_Exam.ex7.num4;

public class StudentTicket extends Ticket {
    private String studentName;

    public StudentTicket(String eventName, int basePrice, String studentName) {
        super(eventName, basePrice);
        this.studentName = studentName;
    }

    int getPrice() {
        return (int)(getBasePrice()*0.7);
    }
    String getInfo() {
        return "학생: " + studentName +", 이벤트: " + getEventName() + ", 할인된 가격: " + getPrice();
    }
}
