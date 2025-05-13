package classes.z_Exam.Harder.ex1;

public abstract class DataContainer<T> {
    private T data;

    public DataContainer(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void displayData() {
    }
}
