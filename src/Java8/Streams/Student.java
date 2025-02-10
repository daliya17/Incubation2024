package Java8.Streams;

import java.util.List;

public class Student {
    private String name;
    private int id;
    private int age;

    public boolean isPassed() {
        return isPassed;
    }

    private boolean isPassed;

    public int getGrade() {
        return grade;
    }

    public String getSection() {
        return section;
    }

    private int grade;

    private String section;

    public List<Address> getAddresses() {
        return addresses;
    }

    private List<Address> addresses;

    public Student(String name, int id, int age, List<Address> addresses, int grade, String section, boolean isPassed) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.addresses = addresses;
        this.grade = grade;
        this.section = section;
        this.isPassed = isPassed;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}
