package classes.z_Exam.ex3.num4;

public class Main {

    public static <T extends Comparable<T>> T findMax(T[] array){
        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(max) > 0) {
                max = array[i];
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Integer[] intArray = {1,2,3,4,5,6};
        String[] strArray = {"a","b","c"};

        System.out.println(findMax(intArray));
        System.out.println(findMax(strArray));
    }
}
