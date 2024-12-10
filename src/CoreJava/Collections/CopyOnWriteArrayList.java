package CoreJava.Collections;

public class CopyOnWriteArrayList {
    // copyOnWriteArrayList is a thread-safe variant of ArrayList in which all mutative operations (add, set, and so on) are implemented by making a fresh copy of the underlying array.
    // This is ordinarily too costly, but if you need to keep a list around that is being frequently modified by one thread while being frequently iterated by another thread, this is the way to go.
    // The "snapshot" style iterator method uses a reference to the state of the array at the point that the iterator was created.
    // This array never changes during the lifetime of the iterator, so interference is impossible and the iterator is guaranteed not to throw ConcurrentModificationException.
    // The iterator will not reflect additions, removals, or changes to the list since the iterator was created.
    // Element-changing operations on iterators themselves (remove, set, and add) are not supported.
    public static void main(String[] args) {
        java.util.concurrent.CopyOnWriteArrayList<String> list = new java.util.concurrent.CopyOnWriteArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        System.out.println(list);

        list.add("Date");
        list.remove("Banana");
        System.out.println("Modified List: " + list);

        // modifying the list while iterating
        for(String s : list) {
            if (s.equals("Apple")) {
                list.remove("Apple");
            }
            list.add("Elderberry");
        }
        System.out.println("Modified List: " + list);
    }
}
