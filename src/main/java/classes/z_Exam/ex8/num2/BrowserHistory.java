package classes.z_Exam.ex8.num2;

import java.util.Stack;

public class BrowserHistory {
    private Stack<String> history;

    public BrowserHistory() {
        history = new Stack<>();
    }

    public void visit(String url) {
        history.add(url);
    }

    public void back() {
        if (!history.isEmpty() && history.size() > 0) {
            System.out.println("기록: " + history.peek() + "를 지우겠습니다.");
            history.pop();
        } else {
            System.out.println("이전 페이지가 없습니다.");
        }
    }

    public void showHistory() {
        if (history.isEmpty()) {
            System.out.println("방문한 사이트가 없습니다.");
        } else {
            for (String s : history) {
                System.out.println(s);
            }
        }
    }
}
