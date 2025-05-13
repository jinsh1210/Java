package classes.H_classes.Ex4;

import classes.H_classes.Ex3.Person;

import java.util.*;
import java.util.stream.Collectors;

public class StreamEx2 {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("홍길동", 20, 1)
                , new Person("홍길자", 29, 2)
                , new Person("홍길순", 25, 2)
                , new Person("홍길석", 27, 1)
        );
        System.out.println(persons);

        System.out.println("여성 목록1 : ");
        for (Person person : persons) {
            if (person.getGender() == 2)
                System.out.println(person);
        }

        System.out.println("여성 목록2 : ");
        persons.stream()
                .filter(p -> p.getGender() == 2)
                .forEach(System.out::println);

        System.out.println("나이순 출력 : ");
        List<Person> ageList = persons.stream()
                .sorted(Comparator.comparing(Person::getAge))
                .toList();
        ageList.forEach(System.out::println);

        System.out.println("나이가 제일 많은 사람 : ");
        Optional<Person> oldPerson = persons.stream()
                .min(Comparator.comparing(Person::getAge));
        System.out.println(oldPerson);
        System.out.println(oldPerson.get());
        System.out.println(oldPerson.get().getAge());

        System.out.println("남자 / 여자 리스트 출력 : ");
        Map<Integer, List<Person>> group = persons.stream()
                .collect(Collectors.groupingBy(Person::getGender));
        group.forEach((gender, pList) -> {
            System.out.println(gender);
            pList.forEach(System.out::println);
        });
    }
}
