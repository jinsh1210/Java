package toc.homework.classes.ex1;

public class MovieArray {
    private String title;
    private double rating;

    //movie
    public MovieArray(String title, double rating) {
        this.title = title;
        this.rating = rating;
    }
/*  public MovieArray() {}    //Getter Setter 이용 시
    //title
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    //rating
    public double getRating() {
        return rating;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }*/
    //출력
    public void showInfo(){
        System.out.print("영화제목 : " + title + " / 평점 : " + rating);
    }
    // 평점 8.0 이상 isRecommended true
    public boolean isRecommended(){
        return rating >= 8.0;
    }
}