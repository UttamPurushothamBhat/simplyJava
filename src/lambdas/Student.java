package lambdas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Student {
    String name;
    int age;
    Grade grade;
    int standard;

    boolean accepted;
}
