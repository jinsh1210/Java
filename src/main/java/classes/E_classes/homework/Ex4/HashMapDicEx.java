package classes.E_classes.homework.Ex4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class HashMapDicEx {
    public static void main(String[] args) {
        HashMap<String, String> dic = new HashMap<String, String>();

        dic.put("baby","아기");
        dic.put("love","사랑");
        dic.put("apple","사과");

        Set<String> keys = dic.keySet();
        Iterator<String> it = keys.iterator();
        while (it.hasNext()) {
            String key = it.next();
            String value = dic.get(key);
            System.out.println(key + "=" + value);
        }
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.print("찾고 싶은 단어 : ");
            String eng = scanner.next();

            String kor = dic.get(eng);
            if(kor == null){
                System.out.println(eng + "는 없는 단어 입니다.");
            }
            else
                System.out.println(kor);
        }
        scanner.close();
    }
}
