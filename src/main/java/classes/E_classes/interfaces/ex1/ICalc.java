package classes.E_classes.interfaces.ex1;

public interface ICalc {

//    public static final int MAX0 = 100;   / 기본 구성
//    static final int MAX1 = 100;        //무조건 public만 사용 가능 / public 생략 가능
//    public final int MAX2 = 100;        //static 생략 가능
//    public static int MAX3 = 100;       //final 생략 가능
    int MAX4 = 100;                     //상수 선언 시 대문자로

    public default void print(){
        System.out.println("AAA");
    }
//    public abstract int add0(int a, int b);       / 기본 구성
//    abstract int add1(int a, int b);          //무조건 public만 (생략가능)
//    public int add2(int a, int b);            //무조건 abstract (생략가능)
    int add(int a, int b);
}
