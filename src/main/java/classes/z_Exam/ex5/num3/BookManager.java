package classes.z_Exam.ex5.num3;

import java.util.LinkedList;

public class BookManager {
    private LinkedList<String> books;

    public BookManager() {
        books = new LinkedList();
    }

    public void viewBooks(String title) {
        if (books.contains(title)) {
            books.remove(title);
        }
        books.addFirst(title);
    }

    public void printBooks() {
        System.out.println("최근 본 책 목록:");
        for (String book : books) {
            System.out.println(book);
        }
    }
}
