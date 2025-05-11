package classes.z_Exam.ex4.num1;

public class Main {
    public static void main(String[] args) {
        MyStack m = new MyStack(args ,10);

        m.push("Apple");
        m.push(3);
        m.push("Banana");
        m.push(15);
        m.push("Cherry");

        while (!m.isEmpty()) {
            System.out.println(m.pop());
        }
    }
}
