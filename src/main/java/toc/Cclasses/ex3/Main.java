package toc.Cclasses.ex3;

public class Main {
    public static void main(String[] args) {
        Animal a = new Animal();
        Dog d = new Dog();
        Cat c = new Cat();

        Animal[] animals = new Animal[3];
        animals[0] = d;
        animals[1] = c;
        animals[2] = a;

        for (int i = 0; i < animals.length; i++) {
            animals[i].sound();
        }
    }
}
