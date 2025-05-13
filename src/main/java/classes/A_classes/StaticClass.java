package classes.A_classes;

public class StaticClass {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        StaticClass sc = new StaticClass();
        int result = sc.add(a,b);
        System.out.println(result);
    }
    private int add(int a, int b) {
        return a + b;
    }
}

