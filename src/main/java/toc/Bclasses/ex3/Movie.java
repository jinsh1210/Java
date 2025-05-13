package toc.Bclasses.ex3;

public class Movie {
    private String title;
    private double rating;

    public Movie(String title, double rating) {
        this.title = title;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void showInfo(){
        System.out.print("제목 : " + title + " / 평점 : " + rating);
    }

    public boolean isRecommended(){
        return rating >= 8.0;
    }
}
