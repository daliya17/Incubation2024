package CoreJava.Collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConcurrentModification {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // Attempting to modify the list during iteration
        Iterator<String> iter
                = list.iterator();

        while (iter.hasNext()) {

            System.out.print(iter.next()
                    + ", ");

            // ConcurrentModificationException
            // is raised here as an element
            // is added during the iteration
            System.out.println(
                    "\n\nTrying to add"
                            + " an element in "
                            + "between iteration\n");
            list.add("Five");
        }
    }
}
