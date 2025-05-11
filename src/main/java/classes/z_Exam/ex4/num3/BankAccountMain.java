package classes.z_Exam.ex4.num3;

public class BankAccountMain {
    public static void main(String[] args) {
        BankAccount b1 = new BankAccount("12312421342","이가난",100000);
        BankAccount b2 = new BankAccount("15543565454","김부자",500000);

        b1.deposit(10000);
        b2.deposit(1000000);
        b1.withdraw(60000);
        b2.withdraw(200000);

        b1.getTotalBalance();
        b2.getTotalBalance();

    }
}
