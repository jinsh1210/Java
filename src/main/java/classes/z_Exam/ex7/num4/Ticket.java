package classes.z_Exam.ex7.num4;

public class Ticket {
    private String eventName;
    private int basePrice;

    public Ticket(String eventName, int basePrice) {
        this.eventName = eventName;
        this.basePrice = basePrice;
    }

    public String getEventName() {
        return eventName;
    }

    public int getBasePrice() {
        return basePrice;
    }

    int getPrice() {
        return basePrice;
    }

    String getInfo() {
        return "이벤트: " + eventName + ", 가격: " + basePrice;
    }
}
