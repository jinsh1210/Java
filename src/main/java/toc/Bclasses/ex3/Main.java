package toc.Bclasses.ex3;

public class Main {
    public static void main(String[] args) {

        Movie m = new Movie("자바",8.0);

        if(m.isRecommended()){
            m.showInfo();
            System.out.println(" [추천 영화]");
        }
        else{
            m.showInfo();
        }
    }
}
