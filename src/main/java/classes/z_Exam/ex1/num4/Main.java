package classes.z_Exam.ex1.num4;

import java.util.ArrayList;

public class Main {
    public static <T> void printArray(T[] array) {
        for (int i =0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
    public static void main(String[] args) {
        Integer[] intArr = {1,2,3,4,5};
        String[] strArr = {"a","b","c"};

        printArray(intArr);
        printArray(strArr);
    }
}
