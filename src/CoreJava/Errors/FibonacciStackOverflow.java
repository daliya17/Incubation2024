package CoreJava.Errors;

public class FibonacciStackOverflow {
  // exceptions in Java are objects, so they are instances of classes that extend Throwable
    // StackOverflowError is a subclass of Error
    // Error is a subclass of Throwable
    // StackOverflowError is an unchecked error, so you don't have to catch it
    // Incorrect Fibonacci method causing StackOverflowError
    public static int fibonacci(int n) {
        // Recursive call without a base case (infinite recursion)
        return fibonacci(n - 1) + fibonacci(n - 2);  // This will keep calling itself
    }

    public static void main(String[] args) {
        // This will cause StackOverflowError due to infinite recursion
        try {
            fibonacci(1000);
        } catch (StackOverflowError e) {
            System.out.println("StackOverflowError occurred: " + e.getMessage());
        }
    }
}

