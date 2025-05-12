package toc.Eclasses.Ex2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionLottoEx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("몇 개를 구매 할건가요? ");
        int num = sc.nextInt();

        //로또 전체 담을 리스트
        List<Integer> all = new ArrayList<>();

        IntStream.range(0, num)
                .forEach(i -> {
                    System.out.print("로또 번호 " + (i + 1) + ": ");
                    List<Integer> lotto = new Random()
                            .ints(1, 46)
                            .distinct()
                            .limit(6)
                            .sorted()
                            .boxed()
                            .collect(Collectors.toList());
                    System.out.println(lotto);
                    all.addAll(lotto);
                });

        // 1~45 각각 몇 개 나왔는지 출력
        System.out.println("\n1~45 각 숫자별 등장 횟수:");
        for (int i = 1; i <= 45; i++) {
            final int numToCheck = i; // i 값을 final 변수에 복사
            long count = all.stream().filter(n -> n == numToCheck).count();
            System.out.printf("%2d: %d\n", i, count);
        }

        sc.close();
    }
}
