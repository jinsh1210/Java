package toc.homework.Inheritance2.ex5;

public class Main {
    public static void main(String[] args) {
        Animal[] as = {new Animal(), new Dog(), new Cat()};
        for (Animal a : as){
            a.sound();
            if (a instanceof Dog) {
                Dog d = (Dog) a;
                d.wagTail();
            } else if (a instanceof Cat) {
                Cat c = (Cat) a;
                c.scratch();
            }
        }
    }
}
