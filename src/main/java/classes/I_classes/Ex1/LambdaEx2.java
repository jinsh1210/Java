package classes.I_classes.Ex1;

public class LambdaEx2 {
    public static void main(String[] args) {
        MyFunction mf = new MyFunction() {
            @Override
            public int max(int a, int b) {
                return a > b ? a : b;
            }
        };
        int res = mf.max(10, 20);
        System.out.println(res);

        MyFunction mf2 = (a, b) -> a > b ? a : b;
        int res2 = mf2.max(30, 20);
        System.out.println(res2);
    }
}
