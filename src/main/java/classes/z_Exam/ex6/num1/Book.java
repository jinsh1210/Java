package classes.z_Exam.ex6.num1;

public class Book extends Item<String> {

    public Book(String title) {
        super(title);
    }

    public void display() {
        System.out.println("Book 제목: " + getContent());
    }
}
