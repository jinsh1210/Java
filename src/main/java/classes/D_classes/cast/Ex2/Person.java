package classes.D_classes.cast.Ex2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    private String name;
    private String id;

    public Person(String name) {
        this.name = name;
    }
}
