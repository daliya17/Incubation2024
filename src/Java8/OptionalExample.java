package Java8;

public class OptionalExample {
    // Java 8 introduced a new class Optional in java.util package. It is used to represent a value is present or absent.
    // It is a public final class and used to deal with NullPointerException in Java application.
    // It provides methods to check the presence of value for particular variable.
    // The main advantage of Optional is that it helps to avoid NullPointerException.
    // It is used to provide a way to handle the null pointer exception.
    // It is a value-based class and it is immutable.
    // the methods of Optional class are:
    // 1. empty() - It is used to return an empty Optional instance.
    public static void main(String[] args) {
        // return empty Optional instance
        java.util.Optional<String> emptyOptional = java.util.Optional.empty();
        System.out.println("Empty" + emptyOptional); // Output: Optional.empty
        // 2. of() - It is used to return a non-empty Optional instance.
        java.util.Optional<String> optional = java.util.Optional.of("Hello");
        System.out.println("Optional: " + optional); // Output: Optional[Hello]
        // Check if the value is present
        System.out.println(optional.isPresent());
        // if present, get the value
        optional.ifPresent(System.out::println); // Output: Hello

//       // 3. ofNullable() - It is used to return a non-empty Optional instance if the value is present, otherwise returns an empty Optional.
        java.util.Optional<String> nullableOptional = java.util.Optional.ofNullable(null);
        System.out.println("Nullable Optional: " + nullableOptional);
        // difference between of() and ofNullable()
       //   java.util.Optional<String> nullOptional = java.util.Optional.of(null); // Throws NullPointerException

        String result = emptyOptional.orElse("Default Value");
        System.out.println(result); // Output: Default Value
    }
}

