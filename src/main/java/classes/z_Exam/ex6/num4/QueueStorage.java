package classes.z_Exam.ex6.num4;

import java.util.LinkedList;

public class QueueStorage<T> extends Storage<T> {
    //Queue
    private LinkedList<T> queue = new LinkedList<>();

    public void addItem(T item) {
        queue.add(item);
    }
    public T retrieveItem() {
        return queue.poll();
    }
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
