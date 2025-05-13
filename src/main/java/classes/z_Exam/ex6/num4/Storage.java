package classes.z_Exam.ex6.num4;

public abstract class Storage <T>{
    public abstract void addItem(T item);
    public abstract T retrieveItem();
    public abstract boolean isEmpty();
}
