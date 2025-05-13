package classes.F_classes.generic.ex1;

public class MyClass<T> {   //타입 매개변수 T로 선언
    private T val;

    //Getter Setter
    public T getVal() {
        return val;
    }
    public void setVal(T val) {
        this.val = val;
    }

}
