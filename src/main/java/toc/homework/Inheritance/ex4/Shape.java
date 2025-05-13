package toc.homework.Inheritance.ex4;

import java.text.DecimalFormat;

public abstract class Shape {

    public abstract double getArea();

    public void printArea() {
//        System.out.println("넓이: " + getArea());
        //소수점 자릿 수 표현 방식
//        System.out.printf("넓이: %.2f%n", getArea());
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("넓이: " + df.format(getArea()));
    }
}
