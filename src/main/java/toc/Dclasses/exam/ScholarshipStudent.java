package toc.Dclasses.exam;

public class ScholarshipStudent extends Student {
    public ScholarshipStudent(String name, int kor, int eng, int math) {
        super(name, kor, eng, math);
    }

    public boolean isEligible() {
        if (getAverage() >= 90) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getGrade() {
        if (isEligible()) {
            return super.getGrade() + "(장학생)";
        } else {
            return super.getGrade() + "(일반)";
        }
    }
}
