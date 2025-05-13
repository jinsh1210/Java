package classes.z_Exam.ex6.num5;

public class NumberProcessor extends DataProcessor<Integer> {
    public boolean validate(Integer item) {
        return item >= 0;
    }
    public Integer transform(Integer item) {
        return item + 10;
    }
}
