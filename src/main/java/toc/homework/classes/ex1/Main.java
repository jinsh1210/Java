package toc.homework.classes.ex1;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieArray[] mv = new MovieArray[3];

        //생성자 활용
        for (int i = 0; i < mv.length; i++) {
            //n번째 제목 입력
            System.out.print((i + 1) + "번째 제목 : ");
            String t = sc.next();
            //n번째 평점 입력
            System.out.print((i + 1) + "번째 평점 : ");
            double r = sc.nextDouble();
            System.out.println();
            //제목, 평점을 mv 배열에 저장
            mv[i] = new MovieArray(t, r);
        }
        //Getter Setter 활용
/*        for (int i = 0; i < mv.length; i++) {
            mv[i] = new MovieArray();
            //n번째 제목 입력
            System.out.print((i + 1) + "번째 제목 : ");
            String t = sc.next();
            mv[i].setTitle(t);
            //n번째 평점 입력
            System.out.print((i + 1) + "번째 평점 : ");
            double r = sc.nextDouble();
            mv[i].setRating(r);
            System.out.println();
        }*/
        //출력
        for (int i = 0; i < mv.length; i++) {
            if (mv[i].isRecommended()) {
                mv[i].showInfo();
                System.out.println(" [추천 영화]");
            } else {
                mv[i].showInfo();
                System.out.println();
            }

        }
    }
}
