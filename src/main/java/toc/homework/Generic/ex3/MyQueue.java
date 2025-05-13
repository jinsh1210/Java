package toc.homework.Generic.ex3;

import java.util.LinkedList;

public class MyQueue <T>{
    LinkedList<T> list = new LinkedList<>();

    public void enqueue(T item){
        list.add(item);
    }
    public T dequeue(){
        return list.removeFirst();
    }
    public boolean isEmpty(){
        return list.isEmpty();
    }
}
