package toc.homework.Generic.ex3;

public class Main {
    public static void main(String[] args) {
        MyQueue<String> q = new MyQueue<>();
        q.enqueue("A");
        q.enqueue("B");
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
    }
}
