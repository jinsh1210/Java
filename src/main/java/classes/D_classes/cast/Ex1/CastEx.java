/* package classes.D_classes.cast.Ex1;

public class CastEx {
    public static void main(String[] args) {

        A a1 = new A();
        A a2 = new A();
        a1 = a2;    //타입이 같아 가능

        B b1 = new B();
        B b2 = new B();
        b1 = b2;    //타입이 같아 가능

        a1 = b1;    //부모 <- 자식 = upcast
//        b2 = a2;    //자식 <- 부모(X) = downcast : 위험성 때문에 직접 형변환 필요


        int a = 10;
        double d = 1.1;

        d = a;
        a = (int) d;
    }
}
 */