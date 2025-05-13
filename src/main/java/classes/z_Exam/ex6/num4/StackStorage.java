package classes.z_Exam.ex6.num4;

import java.util.Stack;

public class StackStorage <T> extends Storage<T>{
    //stack
    private Stack<T> stack = new Stack<T>();

    public void addItem(T item) {
        stack.push(item);
    }
    public T retrieveItem() {
        return stack.pop();
    }
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
