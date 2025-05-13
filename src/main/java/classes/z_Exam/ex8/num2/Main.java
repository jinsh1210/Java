package classes.z_Exam.ex8.num2;

public class Main {
    public static void main(String[] args) {

        BrowserHistory history = new BrowserHistory();

        history.visit("Google");
        history.visit("Youtube");
        history.visit("Naver");

        history.showHistory();
        history.back();
        history.showHistory();
        history.back();
        history.back();
        history.back();
        history.showHistory();
    }
}
