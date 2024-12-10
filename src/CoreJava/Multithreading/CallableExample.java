package CoreJava.Multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {
    // callable is similar to runnable, but it can return a result and can throw a checked exception
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable<Integer> task = () -> {
            Thread.sleep(2000);
            return 100;
        };
        System.out.println("Submitting the task");
        Future<Integer> future = executorService.submit(task);
        System.out.println("Task is submitted");
        try {
            System.out.println("Result of the task is: " + future.get());
        } catch (Exception e) {
            e.printStackTrace();

        }
        System.out.println("Shutting down the executor");
        executorService.shutdown();
    }
}
