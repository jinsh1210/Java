package toc.homework.Generic.ex4;
import java.util.Vector;
public class MyStack <T>{
    Vector v = new Vector();
    public void push(T item){
        v.add(item);
    }
    public T pop(){
        return (T)v.remove(v.size()-1);
    }
    public boolean isEmpty(){
        return v.isEmpty();
    }
}
