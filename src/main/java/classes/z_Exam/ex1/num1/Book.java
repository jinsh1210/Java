package classes.z_Exam.ex1.num1;

public class Book {
    private String title;
    private String author;
    private int price;

    public Book(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void printInfo() {
        System.out.println("제목: " + title + ", 저자: " + author + ", 가격: " + price);
    }
}
