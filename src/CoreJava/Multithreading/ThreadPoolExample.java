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
