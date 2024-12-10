package CoreJava.Collections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SynchronizedMapExample {
    // synchronizedMap() method is used to get a synchronized (thread-safe) map backed by the specified map.
    // In case of synchronized map, all the methods are synchronized and can be accessed by only one thread at a time.
    // It is always recommended to use synchronized map in a multithreaded environment.
    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "arvind");

        // Creating a synchronized map
        Map<Integer, String> synchronizedMap = Collections.synchronizedMap(map);
        synchronizedMap.put(2, "kevin");
        synchronizedMap.put(3, "alex");
        System.out.println(synchronizedMap);

        synchronized (synchronizedMap) {
            for (Map.Entry<Integer, String> entry : synchronizedMap.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
    }
}
