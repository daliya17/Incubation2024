package CoreJava.Generics.Contravariance;

import CoreJava.Generics.Invariance.Animal;
import CoreJava.Generics.Invariance.Dog;

import java.util.ArrayList;
import java.util.List;

public class ContravarianceExample {
// contravarience is the opposite of covariance. It allows you to pass a list of a superclass of T to a method that accepts List<? super T>.
    public static void addAnimals(List<? super Dog> animals) {
        // You can safely add a Dog to the list because the list is guaranteed to be of type Dog or a superclass
        animals.add(new Dog("dog"));
        for (Object animal : animals) {
            System.out.println(animal);
        }

       //  animals.add(new Cat("cat")); // This would NOT compile
    }

    public static void main(String[] args) {
        List<Animal> animalList = new ArrayList<>();
        List<Object> objectList = new ArrayList<>();

        addAnimals(animalList);  // OK, Animal is a superclass of Dog
        addAnimals(objectList);  // OK, Object is a superclass of Dog

    }
}
