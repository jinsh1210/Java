package classes.z_Exam.ex6.num4;

public class Main {
    public static void main(String[] args) {
        StackStorage stack = new StackStorage();
        QueueStorage queue = new QueueStorage();

        stack.addItem(10);
        stack.addItem(20);
        stack.addItem(30);
        queue.addItem(10);
        queue.addItem(20);
        queue.addItem(30);
        System.out.print(stack.retrieveItem() + " ");
        System.out.print(stack.retrieveItem() + " ");
        System.out.println(stack.retrieveItem());
        System.out.print(queue.retrieveItem() + " ");
        System.out.print(queue.retrieveItem() + " ");
        System.out.println(queue.retrieveItem());
    }
}
