package CoreJava.Exceptions.ExceptiionsInInheritance;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Bird bird = new Bird();
        bird.fly();
        Bird pigeon = new Pigeon();
        pigeon.fly();
        Pigeon pigeon1 = new Pigeon();
        pigeon.fly();
    }
}

// if super class method throws a checked exception, then subclass overridden method can only throw same, subclass exception or no exception
// if super class method throws an unchecked exception, then subclass overridden method can throw any unchecked exception
// unchecked exceptions are not part of the method signature even if they are thrown by the method
