package CoreJava.Exceptions;

public class Main {
    // Throwables are objects that can be thrown and caught
    // Throwable is the superclass of all errors and exceptions in Java
    // Errors are exceptions that are thrown by the JVM and should not be caught
    // Exceptions are conditions that occur because of bad input, bad output, or bad programming
    // Exceptions are objects that are thrown and caught
    // checked exceptions are exceptions that must be caught or declared to be thrown
    // unchecked exceptions are exceptions that don't have to be caught or declared to be thrown
    public static void main(String[] args) {
        try {
           CustomExceptionExample.validateAge(13);
        } catch (InvalidAgeException e) {
            System.out.println("InvalidAgeException caught: " + e.getMessage());
        }
    }
}

// exception hierarchy in Java
// Throwable is the superclass of all errors and exceptions in Java
// Error is a subclass of Throwable
// Exception is a subclass of Throwable
// RuntimeException is a subclass of Exception
// checked exceptions are exceptions that must be caught or declared to be thrown
// unchecked exceptions are exceptions that don't have to be caught or declared to be thrown
// checked exceptions are subclasses of Exception that are not subclasses of RuntimeException
// unchecked exceptions are subclasses of RuntimeException
