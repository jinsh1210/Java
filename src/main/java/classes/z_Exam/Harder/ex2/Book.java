package classes.z_Exam.Harder.ex2;

public class Book extends Product<Integer>{
    private String author;

    public Book(String name, Integer price, String author) {
        super(name, price);
        this.author = author;
    }
    public void displayInfo(){
        System.out.println("책 제목: "+getName()+", 저자: "+author+", 가격: "+getValue());
    }
}
