package classes.z_Exam.realTest.test1;

public class Loan {
    private String borrower;
    private double principal;
    private int months;
    private double annualRate;

    public Loan(String borrower, double principal, int months, double annualRate) {
        this.borrower = borrower;
        this.principal = principal;
        this.months = months;
        this.annualRate = annualRate / 100; //%로 100을 나눠줌
    }

    public double getMonthlyPayment() {
        //월 이자
        double montha = (annualRate / 12) * principal;

        return (principal + montha * months) / months;
    }

    public void printLoanInfo() {
        System.out.println(borrower + "님 " + (int) principal + " 원에 대한 월 상환액: " + getMonthlyPayment()+" 원");
        //System.out.printf("%s님 %.0f 원에 대한 월 상환액: %.2f\n", borrower, principal, getMonthlyPayment());
    }
}
