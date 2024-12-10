package CoreJava.CustomKey;

import lombok.Data;

import java.util.Objects;

@Data
public class Person1 {
    private String name;
    private int age;
    private String address;

    public Person1(String name, int age, String address, int netWorth) {
        this.name = name;
        this.age = age;
        this.address = address;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person1 person = (Person1) o;

        if (age != person.age) return false;
        if (!Objects.equals(name, person.name)) return false;
        return Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, address);
    }
}
