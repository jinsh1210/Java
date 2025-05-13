package classes.A_classes;

public class persontest {
    public static void main(String[] args) { //main
        person kim = new person(10, "kim", 1.1, 2.2);
        System.out.println(kim);

        person hong = person.builder()
                .age(23)
                .height(175.6)
                .name("홍길동")
                .weight(78.5)
                .build();

        System.out.println(hong);
    }
}

