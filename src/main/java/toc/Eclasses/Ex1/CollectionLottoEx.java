package toc.Eclasses.Ex1;

import java.util.*;

public class CollectionLottoEx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("몇 개를 구매 할건가요? ");
        int num = sc.nextInt();

        //로또 전체 담을 리스트
        List<Integer> list = new ArrayList<>();

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

            //생성된 로또를 리스트에 저장
            list.addAll(lotto);

            System.out.println();
        }
        //1~45까지 몇 개 있는지 검사 및 출력
        for (int a = 1; a <= 45; a++) {
            final int a_final = a;
            long count = list.stream().filter(n -> n == a_final).count();
            if (count != 0) System.out.println(a + "번: " + count + "개 ");
        }
        sc.close();
    }
}
