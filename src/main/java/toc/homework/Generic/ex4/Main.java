package toc.homework.Generic.ex4;

public class Main {
    public static void main(String[] args) {
        MyStack<Integer> s = new MyStack<>();
        s.push(10);
        s.push(20);
        System.out.println(s.pop());
    }
}
