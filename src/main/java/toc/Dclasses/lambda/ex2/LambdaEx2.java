package toc.Dclasses.lambda.ex2;

public class LambdaEx2 {
    public static void main(String[] args) {
        /*MyFunction mf = new MyFunction() {
            @Override
            public int myMax(int a, int b) {
                return a > b ? a : b;
            }
        };*/
        MyFunction mf = (a, b) -> a > b ? a : b;    // 람다 표현식

        int max = mf.myMax(10, 20);
        System.out.println(max);
    }
}
