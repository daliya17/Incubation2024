package CoreJava.Generics.GenericExample;

public class Main {
    public static void main(String[] args) {
        // Create a Box of type String
        Box<String> stringBox = new Box<>("Hello, Generics!");
        System.out.println(stringBox);

        // Create a Box of type Integer
        Box<Integer> integerBox = new Box<>(123);
        System.out.println(integerBox);

        // Create a Box of type Double
        Box<Double> doubleBox = new Box<>(3.14);
        System.out.println(doubleBox);

        // Use the setter to change the value of the Box
        stringBox.setValue("Updated String");
        System.out.println("Updated stringBox: " + stringBox);
    }
}
