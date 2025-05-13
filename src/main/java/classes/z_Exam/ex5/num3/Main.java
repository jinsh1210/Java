package classes.z_Exam.ex5.num3;

public class Main {
    public static void main(String[] args) {
        BookManager books = new BookManager();

        books.viewBooks("자바의 정석");
        books.viewBooks("Clean Code");
        books.viewBooks("Effective Java");
        books.viewBooks("Clean Code");
        books.viewBooks("Spring 입문");

        books.printBooks();

    }
}
