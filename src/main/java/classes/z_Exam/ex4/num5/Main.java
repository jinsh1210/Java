/* package classes.z_Exam.ex4.num5;

public class Main {

    public static double calculateAverage(Student<Integer>[] students) {
        int sum = 0;
        for (Student<Integer> student : students) {
            sum += student.getScore();
        }
        return (double) sum / students.length;
    }

    public static void main(String[] args) {
        Student<Integer>[] students = new Student[3];
        students[0] = new Student<>("a",85);
        students[1] = new Student<>("b",92);
        students[2] = new Student<>("c",78);

        double average = calculateAverage(students);
        System.out.println(average);
    }
}
 */