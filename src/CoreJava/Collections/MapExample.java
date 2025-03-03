package CoreJava.Collections;

import java.util.*;

public class MapExample {
    public static void main(String[] args) {
        // HashMap Example (No order)
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Apple", 1);
        hashMap.put("Banana", 2);
        hashMap.put("Cherry", 3);
        System.out.println("HashMap: " + hashMap);

        // TreeMap Example (Sorted by key)
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("Dog", 5);
        treeMap.put("Cat", 4);
        treeMap.put("Elephant", 3);
        System.out.println("TreeMap: " + treeMap);

        // LinkedHashMap Example (Maintains insertion order)
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("Red", 1);
        linkedHashMap.put("Blue", 2);
        linkedHashMap.put("Green", 3);
        System.out.println("LinkedHashMap: " + linkedHashMap);
        for(Map.Entry<String, Integer> entry: linkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
