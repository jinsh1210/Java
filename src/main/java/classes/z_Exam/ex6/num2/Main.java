package classes.z_Exam.ex6.num2;

public class Main {
    public static void main(String[] args) {
        Electronics<Integer> e1 = new Electronics<Integer>("노트북",95);
        Electronics<Integer> e2 = new Electronics<Integer>("태블릿",85);

        e1.describe();
        e2.describe();

        if(e1.isBetterThan(e2)){
            System.out.println(e1.getName() + "이 " + e2.getName() + "보다 성능이 우수합니다.");
        } else {
            System.out.println(e2.getName() + "이 " + e1.getName() + "보다 성능이 우수합니다.");
        }
    }
}
