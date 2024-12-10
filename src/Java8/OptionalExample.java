package Java8;

public class OptionalExample {
    // Java 8 introduced a new class Optional in java.util package. It is used to represent a value is present or absent.
    // It is a public final class and used to deal with NullPointerException in Java application.
    // It provides methods to check the presence of value for particular variable.
    public static void main(String[] args) {
        java.util.Optional<String> optional= java.util.Optional.of("Hello");
        // Check if the value is present
        optional.ifPresent(System.out::println); // Output: Hello

        java.util.Optional<String> emptyOptional = java.util.Optional.empty();

        String result = emptyOptional.orElse("Default Value");
        System.out.println(result); // Output: Default Value
    }
}

