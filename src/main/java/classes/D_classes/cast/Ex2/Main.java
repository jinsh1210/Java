package classes.D_classes.cast.Ex2;

public class Main {
    public static void main(String[] args) {
        Person p;
        Student s = new Student("진승현");
        p = s;  // 업캐스팅
//        s = (Student)p; // 다운캐스팅

        p.getName();
    }
}
