package classes.E_classes.interfaces.ex1;


public class Main {
    public static void main(String[] args) {
//        ICalc calc = new Calc();    // Interface는 객체 선언 불가
        ICalc calc = new RealCalc();
        int result = calc.add(10, 20);
        System.out.println("결과1 : " + result);

        RealCalc calc2 = new RealCalc();
        int result2 = calc2.add(100, 200);
        System.out.println("결과2 : " + result2);


    }

}
