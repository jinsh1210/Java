package classes.C_classes.Static;

public class MainStatic {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        int result = StaticClass.add(a, b);
        System.out.println("결과 : " + result);

        System.out.println(Math.PI);
        System.out.println(Math.random());

        /*for (int i = 0; i < StaticEx.MAX; i++) {
            System.out.printf("*");
        }*/
    }
}
