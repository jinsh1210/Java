package classes.z_Exam.ex6.num5;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(10, 5, 20);
        NumberProcessor numberProcessor = new NumberProcessor();
        System.out.print("NumberProcessor 출력: ");
        numberProcessor.processData(numbers);

        List<String> strings = List.of("hello", "world", "java");
        StringProcessor stringProcessor = new StringProcessor();
        System.out.print("StringProcessor 출력: ");
        stringProcessor.processData(strings);

    }
}
