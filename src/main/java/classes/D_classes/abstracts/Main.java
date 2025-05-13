package classes.D_classes.abstracts;

public class Main {
    public static void main(String[] args) {

        Calc calc = new RealCalc();

        int result = calc.add(10, 20);
        System.out.println("결과 : " + result);

        result = calc.sub(20, 10);
        System.out.println("결과 : " + result);
    }
}
