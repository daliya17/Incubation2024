package Java8;

import lombok.Data;

@Data
public class Subject {
    public int id;
    public String name;
    public double grade;

    public Subject(int id,String name, double grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }
}
