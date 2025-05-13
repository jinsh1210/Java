package classes.H_classes.Ex1;

import java.util.ArrayList;
import java.util.List;

public class LambdaEx1 {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("aaa");
        list1.add("bbb");
        list1.add("ccc");
        list1.add("ddd");

        System.out.println(list1);

        for (String str : list1) {
            System.out.println(str);
        }

        List<Integer> list2 = new ArrayList<>(List.of(111, 222, 333, 444));
        list2.forEach(System.out::println);

    }
}
