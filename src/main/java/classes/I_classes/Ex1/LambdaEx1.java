package classes.I_classes.Ex1;

import java.util.*;

public class LambdaEx1 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("dd", "ff", "cc", "aa", "bb");
        Collections.sort(list, (o1, o2) -> o1.compareTo(o2));

        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);

        list = Arrays.asList("dd", "ff", "cc", "aa", "bb");
        System.out.println(list);

        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);

    }
}
