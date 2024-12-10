package CoreJava.Multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {
    // AtomicInteger is used to perform atomic operations on integers
    // Atomic operations are performed in a single step without any interference from other threads
    private static AtomicInteger counter = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {
        Runnable increment = ()->{
            for(int i=0;i<100;i++){
               counter.incrementAndGet();
                System.out.println("Thread: "+Thread.currentThread().getName()+" counter: "+counter.get());
             }
        };
        Thread t1 = new Thread(increment);
        Thread t2 = new Thread(increment);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("final value of counter: "+counter.get());
    }
}
