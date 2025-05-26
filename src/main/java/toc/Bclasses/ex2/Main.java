package toc.Bclasses.ex2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankAccount ba = new BankAccount("진승현", 100000);

        /*ba.deposit(100);
        ba.printBalance();

        ba.withdraw(1100);
        ba.printBalance();*/

        System.out.print("입금(1)/출력(2) : ");
        int cho = sc.nextInt();

        if (cho == 1) {
            //입금 금액
            System.out.print("입금할 금액: ");
            int de = sc.nextInt();
            ba.deposit(de);
        }
        else if (cho == 2) {
            //출금 금액
            System.out.print("출금할 금액: ");
            int wi = sc.nextInt();
            if(ba.getBalance() >= wi){
                ba.withdraw(wi);
            }
            else{
                System.out.println("잔액 부족 ㅋ");
            }
        }
        else{
            System.out.println("다시 선택해주세요.");
        }

        ba.printBalance();
        sc.close();
    }
}
