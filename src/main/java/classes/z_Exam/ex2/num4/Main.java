package classes.z_Exam.ex2.num4;

public class Main {

    public static <T> T getFirstElement(T[] array){
        return array[0];
    }

    public static void main(String[] args) {
        Integer[] intArray = {1,2,3,4,5};
        String[] strArray = {"a","b","c"};

        System.out.println(getFirstElement(intArray));
        System.out.println(getFirstElement(strArray));

    }
}
