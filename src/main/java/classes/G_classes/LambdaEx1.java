/* package classes.G_classes;

import java.io.StringBufferInputStream;
import java.util.*;
import java.util.stream.IntStream;

public class LambdaEx1 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
//        List<Integer> list = new ArrayList<Integer>(Arrays.asList(arr));
        List<Integer> list = Arrays.stream(arr).boxed().toList();
        list.stream().forEach(System.out::println);

        IntStream.of(arr).map(x -> x + 10).sorted().forEach(System.out::println);

        String[] strArr = {"y", "a", "g", "x", "e", "f"};
        List<String> strList = Arrays.stream(strArr).toList();
        strList.stream().sorted().forEach(System.out::println);


    }
}
 */