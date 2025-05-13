package classes.H_classes.Ex2;

public class MyFunctionTest {
    public static void main(String[] args) {

        MyFunction func = (a, b) -> a > b ? a : b;

        /*MyFunction func = new MyFunction(){

            @Override
            public int max(int a, int b) {
                return a>b?a:b;
            }
        };*/

        int val = func.max(10, 20);
        System.out.println(val);

    }
}
