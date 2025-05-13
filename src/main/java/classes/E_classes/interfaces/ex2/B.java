package classes.E_classes.interfaces.ex2;

public interface B extends A, C {   //Interface는 다중상속 가능
                                    //Class에서는 불가능(단일상속만 가능)
    int sub(int a, int b);
}
