package classes.F_classes.generic.ex2;

import java.awt.Point;

public class Main {
    public static void main(String[] args) {

        MyGenArray<Point> parr = new MyGenArray<>(3);
        parr.set(0, new Point(10, 20));
        parr.set(1, new Point(20, 30));
        parr.set(2, new Point(30, 40));

        System.out.println(parr);

        for (int i = 0; i < parr.length(); i++) {
            System.out.println(parr.get(i).getX());
        }

        /*MyGenArray<String> arr = new MyGenArray<>(3);
        arr.set(0, "aaa");
        arr.set(1, "bbb");
        arr.set(2, "ccc");

        System.out.println(arr);

        for(int i=0;i<arr.length();i++){
            System.out.println(arr.get(i));
        }*/


    }
}
