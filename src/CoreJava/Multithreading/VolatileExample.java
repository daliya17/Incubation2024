package CoreJava.Multithreading;

public class VolatileExample {
    // volatile keyword is used to indicate that a variable's value will be modified by different threads, so that the JVM does not cache the value of the variable.
    private static volatile boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        Thread writerThread = new Thread(() -> {
            try {
                Thread.sleep(1000);
                flag = true;  // Write to volatile variable
                System.out.println("Flag set to true");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread readerThread = new Thread(() -> {
            while (!flag) {
                // Continuously check the flag
            }
            System.out.println("Flag is true, reader thread can proceed");
        });

        writerThread.start();
        readerThread.start();

        writerThread.join();
        readerThread.join();
    }
}
