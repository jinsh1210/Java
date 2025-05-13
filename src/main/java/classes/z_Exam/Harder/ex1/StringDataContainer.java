package classes.z_Exam.Harder.ex1;

public class StringDataContainer extends DataContainer<String> {

    public StringDataContainer(String data) {
        super(data);
    }

    public void displayData() {
        System.out.println("문자열 데이터: " + getData());
    }
}
