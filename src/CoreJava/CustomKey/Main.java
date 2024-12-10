package CoreJava.CustomKey;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        // custom key in hashmap example
        // Before overriding hashCode() method and equals in Person class
        Person p1 = new Person("Naman", 21, "Delhi", 1000000);
        Person p2 = new Person("Naman", 21, "Delhi", 1000000);
        Map<Person,String> map = new HashMap<>();
        map.put(p1,"Naman");
        map.put(p2,"Naman");
        System.out.println(map.size()); // Output: 2

        System.out.println(p1.equals(p2)); // Output: true

        // After overriding hashCode() method and equals in Person class
        Person1 p3 = new Person1("Naman", 21, "Delhi", 1000000);
        Person1 p4 = new Person1("Naman", 21, "Delhi", 1000000);
        Map<Person1,String> map1 = new HashMap<>();
        map1.put(p3,"Naman");
        map1.put(p4,"Naman");
        System.out.println(map1.size()); // Output: 1
        System.out.println(p3.equals(p4)); // Output: true

        // mutable key
        p3.setAge(22);
        System.out.println(map1.get(p3)); // Output: null

        // immutable key
        ImmutablePerson p5 = new ImmutablePerson("Naman", 21, "Delhi");
        ImmutablePerson p6 = new ImmutablePerson("Naman", 21, "Delhi");
        Map<ImmutablePerson,String> map2 = new HashMap<>();
        map2.put(p5,"Naman");
        map2.put(p6,"Naman");
        System.out.println(map2.size()); // Output: 1
        System.out.println(p5.equals(p6)); // Output: true
    }
}
