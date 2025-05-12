package toc.Eclasses.Ex1;

import java.util.*;

public class CollectionLottoEx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("몇 개를 구매 할건가요? ");
        int num = sc.nextInt();

        for (int i = 0; i < num; i++) {
            System.out.print("로또 번호 " + (i + 1) + ": ");

            Set<Integer> lotto = new HashSet<>();

            Random rnd = new Random();
            while (lotto.size() < 6) {
                int rand = rnd.nextInt(45) + 1;
                lotto.add(rand);
            }

            lotto.stream()
                    .sorted()
                    .forEach(n -> System.out.print(n + " "));
            System.out.println();
        }
        sc.close();
    }
}
