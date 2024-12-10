package CoreJava.CustomKey;

import java.util.Objects;

public final class ImmutablePerson {
    private final String name;
    private final int age;
    private final String address;

    public ImmutablePerson(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "ImmutablePerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImmutablePerson person = (ImmutablePerson) o;

        if (age != person.age) return false;
        if (!name.equals(person.name)) return false;
        return address.equals(person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, address);
    }
}
