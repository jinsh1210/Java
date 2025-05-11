package classes.F_classes.generic.ex2;

import lombok.ToString;

@ToString
public class MyGenArray<T> {

    private T[] arr;

    public MyGenArray(int size) {
        this.arr = (T[]) new Object[size];
    }

    public void set(int index, T val) {
        arr[index] = val;
    }
    //arr[index] 값의 매개변수 타입이 T여서 void가 아닌 T로 선언
    public T get(int index) {
        return arr[index];
    }
    public int length(){
        return arr.length;
    }


    //getter setter
    public T[] getArr() {
        return arr;
    }
    public void setArr(T[] arr) {
        this.arr = arr;
    }
}
