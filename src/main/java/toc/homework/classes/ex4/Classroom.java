package toc.homework.classes.ex4;

public class Classroom {
    private String[] studentNames;
    private int[] studentScores;

    public Classroom(String[] studentNames, int[] studentScores) {
        this.studentNames = studentNames;
        this.studentScores = studentScores;
    }

    public double getAverageScore() {
        int sum = 0;
        for (int i = 0; i < studentScores.length; i++) {
            sum += studentScores[i];
        }
        return (double) sum / studentScores.length;
    }

    public String getTopStudent() {
        int highest = 0;
        for (int i = 0; i < studentScores.length; i++) {
            if (studentScores[i] > studentScores[highest]) {
                highest = i;
            }
        }
        return studentNames[highest];
    }

    public String getAllStudentInfo() {
        String info = "";
        for (int i = 0; i < studentScores.length; i++) {
            info += studentNames[i] + ": " + studentScores[i] + " 점\n";
        }
        return info;
    }
}
