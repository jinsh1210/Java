package classes.z_Exam.ex5.num1;

public class Main {
    public static void main(String[] args) {
        Box<String> box = new Box<>(3);
        Box<Integer> box2 = new Box<>(3);

        box.add("aaa");
        box.add("bbb");
        box.add("ccc");
        box2.add(1);
        box2.add(2);
        box2.add(3);

        for(int i =0;i<box.getSize();i++){
            System.out.println(box.get(i));
        }
        for(int i =0;i<box2.getSize();i++){
            System.out.println(box2.get(i));
        }
    }
}
