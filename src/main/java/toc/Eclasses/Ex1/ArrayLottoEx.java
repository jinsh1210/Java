package toc.Eclasses.Ex1;

import java.util.Random;
import java.util.Scanner;

public class ArrayLottoEx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("몇 개를 구매 할건가요? ");
        int num = sc.nextInt();

        for (int i = 0; i < num; i++) {
            System.out.print("로또 번호 " + (i + 1) + ": ");

            int[] lotto = new int[6];
            Random rnd = new Random();

            for (int j = 0; j < lotto.length; j++) {
                int rand = rnd.nextInt(45) + 1;
                lotto[j] = rand;

                //중복체크
                for (int k = 0; k < j; k++) {
                    if (rand == lotto[k]) {
                        j--;
                        break;
                    }
                }
            }
            //오름차순
            for (int k = 0; k < lotto.length; k++) {
                for (int j = k + 1; j < lotto.length; j++) {
                    if (lotto[k] > lotto[j]) {
                        int temp = lotto[k];
                        lotto[k] = lotto[j];
                        lotto[j] = temp;
                    }
                }
            }
            //출력
            for (int j : lotto) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
