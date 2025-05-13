package classes.z_Exam.ex4.num1;

public class MyStack <T>{
    private Object[] stack;
    private int size;
    private int top;

    public int getSize() {
        return size;
    }

    public MyStack(Object[] stack, int size) {
        this.size = size;
        this.stack = new Object[size];
    }

    public void push(T t) {
        stack[++top] = t;
    }
    public T pop() {
        if(top == 0){
            return null;
        }else{
            return (T) stack[top--];
        }
    }
    public boolean isEmpty() {
        return top == 0;
    }
}
