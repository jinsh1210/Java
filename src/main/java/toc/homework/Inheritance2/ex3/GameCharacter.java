package toc.homework.Inheritance2.ex3;

public abstract class GameCharacter {
    public void attack(){
        selectWeapon();
        move();
        hit();
    }
    public abstract void selectWeapon();
    public abstract void hit();
    public void move(){
        System.out.println("적에게 이동");
    }
}
