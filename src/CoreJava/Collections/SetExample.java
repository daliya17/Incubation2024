package CoreJava.Collections;

import java.util.*;

public class SetExample {
    public static void main(String[] args) {
        // HashSet Example (No order)
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Apple");
        hashSet.add("Banana");
        hashSet.add("Cherry");
        hashSet.add("Apple"); // Duplicate will be ignored
        System.out.println("HashSet: " + hashSet);

        // LinkedHashSet Example (Insertion order is preserved)
        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("Dog");
        linkedHashSet.add("Cat");
        linkedHashSet.add("Elephant");
        System.out.println("LinkedHashSet: " + linkedHashSet);

        // TreeSet Example (Sorted order)
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("Red");
        treeSet.add("Blue");
        treeSet.add("Green");
        System.out.println("TreeSet: " + treeSet);
    }
}
