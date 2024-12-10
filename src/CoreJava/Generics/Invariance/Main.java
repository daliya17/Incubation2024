package CoreJava.Generics.Invariance;

import java.util.ArrayList;
import java.util.List;

public class Main {
    // invariant means that you can't use a List<Animal> as a List<Dog> or vice versa.
    public static void main(String[] args) {
        // Create a List of Dog
        List<Dog> dogList = new ArrayList<>();
        dogList.add(new Dog("dog1"));

        // compile error List<Dog> is not a subtype of List<Animal>
      //  List<Animal> animals = dogList;
        // Even though Dog is a subtype of Animal, the generic type List<Dog> is not related to List<Animal>

    }
}
