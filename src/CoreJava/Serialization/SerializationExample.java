package CoreJava.Serialization;

import java.io.*;

public class SerializationExample {
    // serialization is the process of converting an object into a stream of bytes to store the object or transmit it to memory, a database, or a file22.
    // deserilization is the process of converting an object from a stream of bytes to an object.
    // transient keyword is used to indicate that a field should not be serialized.
    // static fields are not serialized.
    // serialVersionUID is a unique identifier for Serializable classes.
    // writeObject, readObject, writeReplace, readResolve are the methods that can be used to customize the serialization and deserialization process.
    // ObjectInputValidation is an interface that can be implemented to validate the object after deserialization.
    // singleton pattern can be implemented using readResolve method.

    public static void main(String[] args){
     Person person = new Person("Naman", 22, "address", 1000);
     try {
         FileOutputStream fileOut = new FileOutputStream("person.ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(person);
         out.close();
         fileOut.close();
         System.out.println("Serialized data is saved in person.ser");
     } catch (Exception e) {
            e.printStackTrace();
     }
     Person deserializedPerson = null;
        try {
            FileInputStream fileIn = new FileInputStream("person.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            deserializedPerson= (Person) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Deserialized data from person.ser " + deserializedPerson);
            System.out.println("Deserialized data from person.ser " + deserializedPerson.getName());
            System.out.println("Deserialized data from person.ser " + deserializedPerson.getAge());
            System.out.println("Deserialized data from person.ser " + deserializedPerson.getAddress());
            System.out.println("Deserialized data from person.ser " + deserializedPerson.getNetWorth());
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
