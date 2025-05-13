package classes.z_Exam.ex6.num1;

public abstract class Item<T> {
    private T content;

    public T getContent() {
        return content;
    }

    public Item(T content) {
        this.content = content;
    }

    public abstract void display();
}
