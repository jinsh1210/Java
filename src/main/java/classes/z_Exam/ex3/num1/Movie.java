package classes.z_Exam.ex3.num1;

public class Movie {
    private String title;
    private String director;
    private int year;

    public Movie(String title, String director, int year) {
        this.title = title;
        this.director = director;
        this.year = year;
    }
    public void showDetails() {
        System.out.println("제목: " + title+", 감독: "+director+", 연도: "+year);
    }
}
