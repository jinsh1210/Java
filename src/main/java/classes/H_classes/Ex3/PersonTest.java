package classes.H_classes.Ex3;

public class PersonTest {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.setName("홍길동");
        p1.setAge(20);
        p1.setGender(1);
        System.out.println(p1);

        Person p2 = new Person("홍길자",30,2);
        System.out.println(p2);

        Person p3 = Person.builder()
                .gender(1)
                .age(32)
                .name("손흥민")
                .build();
        System.out.println(p3);
    }
}
