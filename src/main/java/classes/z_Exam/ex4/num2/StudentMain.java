package classes.z_Exam.ex4.num2;

public class StudentMain {
    public static void main(String[] args) {
        Student[] stu = new Student[3];
        stu[0] = new Student("홍길동",202245012,"컴시과");
        stu[1] = new Student("손흥민",202245034,"산디과");
        stu[2] = new Student("가나다",202245056,"실건과");

        for(int i=0;i<stu.length;i++){
            stu[i].printInfo();
        }
    }
}
