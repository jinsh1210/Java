package classes.z_Exam.ex5.num6;

import java.util.LinkedList;

public class StudentContainer<T> {
    private T[] array;
    private LinkedList<T> list;

    public StudentContainer() {
        array = (T[]) new Object[5];
        list = new LinkedList<>();
    }
    public void add(T data){
        boolean added = false;
        for (int i = 0; i < array.length; i++) {
            if(array[i] == null){
                array[i] = data;
                added = true;
                break;
            }
        }
        if(!added){
            System.out.println("배열 저장 실패");
        }
        list.add(data);
    }
    public void print(){
        System.out.println("[배열에 저장된 데이터]");
        for (T data : array) {
            System.out.println(data);
        }
        System.out.println("[리스트에 저장된 데이터]");
        for (T data : list) {
            System.out.println(data);
        }
    }
}
