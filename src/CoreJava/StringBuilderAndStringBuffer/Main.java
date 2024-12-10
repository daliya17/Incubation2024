package CoreJava.StringBuilderAndStringBuffer;

public class Main {
    public static void main(String[] args) {

        // StringBuilder and StringBuffer are mutable, while String is immutable
        // StringBuilder is faster than StringBuffer because it is not synchronized
        // StringBuffer is synchronized, so it is thread-safe
        // StringBuilder is not synchronized, so it is not thread-safe
        // Test with String (using concatenation)
        long startTime = System.nanoTime();
        String str = "Hello";
        for (int i = 0; i < 10000; i++) {
            str += " World"; // This creates a new String each time
        }
        long endTime = System.nanoTime();
        System.out.println("String concatenation time: " + (endTime - startTime) + " ns");

        // Test with StringBuffer
        startTime = System.nanoTime();
        StringBuffer sb = new StringBuffer("Hello");
        for (int i = 0; i < 10000; i++) {
            sb.append(" World");
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer append time: " + (endTime - startTime) + " ns");

        // Test with StringBuilder
        startTime = System.nanoTime();
        StringBuilder sb2 = new StringBuilder("Hello");
        for (int i = 0; i < 10000; i++) {
            sb2.append(" World");
        }
        endTime = System.nanoTime();
        System.out.println("StringBuilder append time: " + (endTime - startTime) + " ns");
    }
}
