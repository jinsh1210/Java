package classes.E_classes.collection.vector;
import java.util.Vector;

public class VecEx1 {
    public static void main(String[] args) {

        var vec = new Vector<>();


        Vector<Integer> intVec = new Vector<Integer>(3);
        intVec.add(Integer.valueOf(1));           //귀찮음
        intVec.add(10);                             //위와 동일함
        intVec.add(100);
        intVec.add(1000);
        intVec.add(2, 55);

        System.out.println(intVec.capacity());          //용량
        System.out.println(intVec.size());              //개수    / capacity 보다 많이 사용
        System.out.println(intVec.contains(100));       //contains(Value): Vector에서 Value가 있는지 boolean
        System.out.println(intVec.elementAt(1));  //index에 있는 요소 값 출력
        System.out.println(intVec.indexOf(10));         //100이라는 값이 어느 index에 있는지 출력
        System.out.println(intVec.get(3));              //제일 대표적 / .elementAt과 동일


        System.out.println("===========================================");


        for (Integer i : intVec) {
            System.out.println(i);
        }

        Vector<String> strVec = new Vector<String>();   //문자열만 받는 Vector
        strVec.add("AAA");
        strVec.add("BBB");
        strVec.add("123");

        for (String str : strVec) {
            System.out.println(str);
        }
    }
}
