package toc.homework.Generic.ex2;
import java.util.Arrays;
import java.util.List;
public class Main {
    public static <T> void printList(List<T> list) {
        for (T t : list) {
            System.out.print(t + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 3);
        List<String> strList = Arrays.asList("a", "b", "c");
        printList(intList);
        printList(strList);
    }
}
