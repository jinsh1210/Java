package toc.Dclasses.exam;

public class Student {
    private String name;
    private int kor;
    private int eng;
    private int math;

    public Student(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    public String getName() {
        return name;
    }

    public double getAverage() {
        return (kor + eng + math)/3.0;
    }
    public String getGrade(){

        if(getAverage()>=90){
            return "A";
        } else if(getAverage()>=80){
            return "B";
        } else if(getAverage()>=70){
            return "C";
        } else{
            return "F";
        }
    }
}
