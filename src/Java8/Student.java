package Java8;

import lombok.Data;

import java.util.List;

@Data
public class Student {
    public int id;
    public String name;
    public int age;
    public List<Subject> subjects;

    public Student(int id, String name, int age, List<Subject> subjects) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.subjects = subjects;
    }
}
