package toc.Eclasses.Ex3;

@FunctionalInterface
interface Func1 {
    void method();
}
@FunctionalInterface
interface Func2 {
    void method(String a, String b);
}
@FunctionalInterface
interface Func3 {
    String method();
}
@FunctionalInterface
interface Func4 {
    String method(String a, String b);
}

public class LambdaFormat {
    public static void main(String[] args) {

        Func1 f1 = () -> System.out.println("람다식 기본 형태");
        f1.method();

        Func2 f2 = (a, b) -> {
            String res2 = a + " " + b;
            System.out.println(res2);
        };
        f2.method("인하공전", "컴시과");

        Func3 f3 = () -> "인하공전 컴시과";
        String res3 = f3.method();
        System.out.println(res3);

        Func4 f4 = (a,b) -> a + " " + b;
        String res4 = f4.method("인하공전", "컴시과");
        System.out.println(res4);

    }
}
