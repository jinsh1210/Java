package classes.z_Exam.ex7.num4;

public class VipTicket extends Ticket {

    public VipTicket(String eventName, int basePrice) {
        super(eventName, basePrice);
    }

    int getPrice() {
        return (int) (getBasePrice() * 1.5);
    }

    String getInfo() {
        return "VIP 이벤트: " + getEventName() + ", 가격: " + getPrice();
    }
}
