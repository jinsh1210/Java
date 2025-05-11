package classes.z_Exam.Harder.ex1;

public class IntegerDataContainer extends DataContainer<Integer> {

    public IntegerDataContainer(Integer data) {
        super(data);
    }

    public void displayData() {
        System.out.println("정수형 데이터: " + getData());
    }
}
