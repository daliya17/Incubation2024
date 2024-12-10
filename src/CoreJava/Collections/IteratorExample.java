package CoreJava.Collections;

public class IteratorExample {
    // iterator in java is used to iterate over a collection of objects
    public static void main(String[] args) {
        java.util.ArrayList<String> list = new java.util.ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        System.out.println(list);

        java.util.Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            if (s.equals("Apple")) {
                iterator.remove();
            }
        }
        System.out.println("Modified List: " + list);
    }
}
