package classes.z_Exam.ex6.num1;

public class Movie extends Item<Double> {

    public Movie(double rate) {
        super(rate);
    }

    public void display() {
        System.out.println("Movie 평점: " + getContent());
    }
}
