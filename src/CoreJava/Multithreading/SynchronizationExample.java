package CoreJava.Multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizationExample {
    private int count = 0;

    private Lock lock = new ReentrantLock();

    public int getCount() {
        return count;
    }

    // no synchronized block
    public void increment() {
        count++;
    }

    public synchronized void increment1() {
        count++;
    }

    // synchronized block
    public void increment2() {
        synchronized (this) {
            count++;
        }
    }

    // using lock object
    public void increment3() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizationExample synchronizedMethodExample = new SynchronizationExample();
        Runnable increment = () -> {
            for (int i = 0; i < 1000; i++) {
                synchronizedMethodExample.increment();
                System.out.println("Thread: " + Thread.currentThread().getName() + " count: " + synchronizedMethodExample.getCount());
            }
        };
        Thread t1 = new Thread(increment);
        Thread t2 = new Thread(increment);
        Thread t3 = new Thread(increment);
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println("final value of count: " + synchronizedMethodExample.getCount());
    }
}
