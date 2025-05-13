package toc.homework.Inheritance.ex3;

public class Main {
    public static void main(String[] args) {

        Animal[] animals = new Animal[3];
        animals[0] = new Dog();
        animals[1] = new Cat();
        animals[2] = new Animal();

        /*for (int i = 0; i < animals.length; i++) {
            animals[i].sound();
        }*/

        for(Animal animal : animals) {
            animal.sound();
        }
    }
}
