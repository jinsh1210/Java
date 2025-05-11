package toc.Cclasses.ex5;

public abstract class Employee {
    private String name;    //이름
    private int baseSalary; //기본급

    public String getName() {
        return name;
    }
    public int getBaseSalary() {
        return baseSalary;
    }

    public Employee(String name, int baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public abstract int getSalary();

    public void printInfo(){
        System.out.println("이름: " + name + ", 월급: "+getSalary()+" 만원");
    }
}
