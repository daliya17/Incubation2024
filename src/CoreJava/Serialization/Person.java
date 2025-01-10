package CoreJava.Serialization;

import lombok.Getter;

import java.io.*;

@Getter
public class Person implements Serializable, ObjectInputValidation {
    private static final long serialversionUID = 1L; // explicit serialVersionUID

    private String name;

    private int age;

    private String address;

    transient int netWorth;


    public Person(String name, int age, String address, int netWorth) {
        this.age = age;
        this.name = name;
        this.address = address;
        this.netWorth = netWorth;
    }

    @Serial
    private void writeObject(ObjectOutputStream out) throws IOException {
        System.out.println("writeObject method called");
        out.defaultWriteObject();

        // extra logic to write
        out.writeObject("Extra data");
    }


    @Serial
    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
        System.out.println("readObject method called");
        in.registerValidation(this, 0);
        in.defaultReadObject();
        // extra logic to read
        String extraData = (String) in.readObject();
        System.out.println("Extra data: " + extraData);
    }

    @Serial
    private Object writeReplace() throws ObjectStreamException {
        System.out.println("writeReplace method called");
        return this;
    }

    // readResolve method is called after readObject method, it is used to return the singleton instance
    @Serial
    private Object readResolve() throws ObjectStreamException {
        System.out.println("readResolve method called");
        return this;
    }

    @Override
    public void validateObject() throws InvalidObjectException {
        System.out.println("validateObject method called");
    }
}
