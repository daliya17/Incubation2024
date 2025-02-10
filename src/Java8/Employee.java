package Java8;

import lombok.Data;

import java.util.List;

@Data
public class Employee {
    public int age;
    public String name;
    public List<String> projects;

    public Employee(int age, String name, List<String> projects) {
        this.age = age;
        this.name = name;
        this.projects = projects;
    }
}
