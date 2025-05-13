package classes.z_Exam.Harder.ex2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Product<Integer>> products = new ArrayList<>();

        products.add(new Book("aaa",10000, "작가1"));
        products.add(new Book("bbb",20000, "작가1"));
        products.add(new Phone("aaa",1040000, "갤럭시"));
        products.add(new Phone("bbb",2040000, "아이폰"));

        for(int i = 0 ; i < products.size() ; i++){
            products.get(i).displayInfo();
        }
    }
}
