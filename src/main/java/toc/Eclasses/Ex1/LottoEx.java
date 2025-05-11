package toc.Eclasses.Ex1;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoEx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("몇 개를 구매 할건가요? ");
        int num = sc.nextInt();

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
                });
        sc.close();
    }
}
