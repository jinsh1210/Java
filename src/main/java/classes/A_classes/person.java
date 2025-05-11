package classes.A_classes;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder //요물
@ToString

public class person {
    // 필드
    private int age;
    private String name;
    private double height;
    private double weight;

    @Override
    public String toString() {
        return "person(" +
                "age=" + age +
                ", name=" + name +
                ", height=" + height +
                ", weight=" + weight +
                ')';
    }
}
