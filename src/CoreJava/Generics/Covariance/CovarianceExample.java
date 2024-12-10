package CoreJava.Generics.Covariance;

import CoreJava.Generics.Invariance.Animal;
import CoreJava.Generics.Invariance.Cat;
import CoreJava.Generics.Invariance.Dog;

import java.util.ArrayList;
import java.util.List;

public class CovarianceExample {

    // covariance is the ability to pass a list of a subclass of T to a method that accepts List<? extends T>.
    public static void printAnimals(List<? extends Animal> animals) {
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("dog"));

        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("cat"));

        // Both Dog and Cat are subclasses of Animal
        // You can pass both lists of Dogs and Cats to printAnimals()
        printAnimals(dogs);
        printAnimals(cats);
    }
}


