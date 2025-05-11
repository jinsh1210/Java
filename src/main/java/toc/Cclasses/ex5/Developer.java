package toc.Cclasses.ex5;

public class Developer extends Employee {
    public Developer(String name, int baseSalary) {
        super(name, baseSalary);
    }

    public int getSalary(){
        return getBaseSalary() + (int)(getBaseSalary() * 0.1);
    }
}
