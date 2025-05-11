package classes.z_Exam.ex5.num1;

public class Box<T> {
    private Object[] items;
    private int size;

    public Box(int capacity) {
        items = new Object[capacity];
        size = 0;
    }

    public void add(T item) {
        if (size >= items.length) {
            System.out.println("Box overflow");
            return;
        }
        items[size++] = item;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return (T) items[index];
    }

    public int getSize() {
        return size;
    }
}
