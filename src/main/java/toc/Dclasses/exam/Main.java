package toc.Dclasses.exam;

public class Main {
    public static void main(String[] args) {
        /*Student s = new Student("홍길동",90,85,88);
        System.out.printf("%.2f\n",s.getAverage());
        System.out.println(s.getGrade());*/

        Student[] s = new Student[3];
        s[0] = new Student("홍길동", 90, 85, 88);
        s[1] = new ScholarshipStudent("이몽룡", 95, 94, 97);
        s[2] = new ScholarshipStudent("성춘향", 80, 85, 83);

        for(Student student : s) {
            System.out.println("이름: " + student.getName());
            System.out.printf("평균: %.2f\n", student.getAverage());
            System.out.println("등급: "+student.getGrade());
            if(student instanceof ScholarshipStudent) {
                System.out.println("장학금 대상 여부: "+((ScholarshipStudent) student).isEligible());
            } else{
                System.out.println("장학금 대상 여부: false");
            }
            System.out.println();
        }
    }
}
