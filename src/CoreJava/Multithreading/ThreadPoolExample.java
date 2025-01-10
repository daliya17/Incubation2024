package CoreJava.Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Runnable printThredName = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("count :" + i + " \t" + Thread.currentThread().getName());
            }
        };
        for(int i=0;i<20;i++){
            executorService.submit(printThredName);
        }
        executorService.shutdown();
    }
}

// executor service is used to manage threads in a thread pool, it is an interface in java.util.concurrent package
// Executors is a utility class to create different types of executor services
// newFixedThreadPool creates a thread pool with a fixed number of threads
// submit method is used to submit a task to the executor service
// shutdown method is used to shutdown the executor service
// we dont have to create a new thread for each task, we can submit the task to the executor service and it will manage the threads in the thread pool
