package classes.z_Exam.ex6.num5;

public class StringProcessor extends DataProcessor<String> {
    public boolean validate(String item) {
        return item != null && !item.isEmpty();
    }

    @Override
    public String transform(String item) {
        return item.toUpperCase();
    }
}
