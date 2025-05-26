/* package classes.z_Exam.ex4.num3;

public class BankAccount {
    private String accountNo;
    private String owner;
    private int balance;

    //생성자
    public BankAccount(String accountNo, String owner, int balance) {
        this.accountNo = accountNo;
        this.owner = owner;
        this.balance = balance;
    }

    //입금
    public void deposit(int amount) {
        balance += amount;
    }

    //출금
    public void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("잔액부족");
        }
    }

    public void getTotalBalance() {
        System.out.println("예금주: " + owner + " 현재 잔액: " + balance);
    }
}
 */