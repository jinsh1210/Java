package classes.z_Exam.ex6.num5;

import java.util.*;

public abstract class DataProcessor<T> {
    public void processData(List<T> data){
        List<T> result = new LinkedList<>();
        // Queue<T> queue = new LinkedList<>();
        // Stack<T> stack = new Stack<>();
        // Vector<T> vector = new Vector<>();
        for(T item : data){
            if(validate(item)){
                result.add(transform(item));
            }
        }
        System.out.println(result);
    }

    public abstract boolean validate(T item);  //0이상인지 확인
    public abstract T transform(T item); //10을 더함
}
