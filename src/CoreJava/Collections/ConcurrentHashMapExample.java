package CoreJava.Collections;

import java.util.concurrent.*;

public class ConcurrentHashMapExample {
    // concurrentHashMap is thread-safe
    // concurrent hashmap implementation is different from hashmap
    // it uses separate locks for different buckets
    // it allows concurrent read and write operations
    // hashmap is divided into segments, each segment has its own lock
    // it allows multiple threads to read and write concurrently
    // it is thread-safe without synchronizing the whole map
    // it is faster than hashtable because hashtable locks the whole map
    // it is slower than hashmap for single-threaded programs
    // read operations do not block each other
    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();

//        map.put("A", 1);
//        map.put("B", 2);
//
//        map.putIfAbsent("A", 3);  // replace the value of "A" because it's already present

        // Thread for updating map concurrently
        Runnable task = () -> {
            for (int i = 0; i < 5; i++) {
                map.putIfAbsent(i, map.getOrDefault(i, 0) + 1);
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        map.forEach((k, v) -> System.out.println(k + " : " + v));
    }
}
