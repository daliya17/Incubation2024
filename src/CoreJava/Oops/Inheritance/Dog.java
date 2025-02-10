package CoreJava.Oops.Inheritance;

import java.util.ArrayList;
import java.util.List;

public class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("CoreJava.Oops.Inheritance.Dog barks");
    }

    @Override
    public List<Object> name() {
        return new ArrayList<>(List.of("Dog name"));
    }

    @Override
    public Man getMammal(){
        return new Man();
    }
}

// sub classes can override the methods of the parent class, the return type of the overridden method must be the same as the parent class method or a subclass of the parent class method
// the access modifier of the overridden method can be the same or less restrictive than the parent class method
// the overridden method can throw any unchecked exception, but it cannot throw a checked exception that is not part of the parent class method signature
// the overridden method can throw a checked exception that is part of the parent class method signature

// primitive types cannot be overridden, only objects can be overridden