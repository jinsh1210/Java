package toc.Cclasses.ex5;

public class Manager extends Employee {

    public Manager(String name, int baseSalary) {
        super(name, baseSalary);
    }

    public int getSalary(){
        return getBaseSalary() + 100;
    }
}
