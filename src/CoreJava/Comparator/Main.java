package CoreJava.Comparator;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> pple = new ArrayList<>();
        pple.add(new Person("Dalia",26));
        pple.add(new Person("Naman", 26));
        pple.add(new Person("Bobby", 25));
        pple.add(new Person("Changu", 35));
        pple.add(new Person("Alina", 30));

        Comparator<Person> compareByName = new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getName().compareTo(p2.getName());
            }
        };
        pple.sort(compareByName);

        for (Person person : pple) {
            System.out.println(person);
        }

        Comparator<Person> compareByAgeThenName = Comparator.comparing((Person::getAge)).thenComparing(Person::getName);
        pple.sort(compareByAgeThenName);
        for (Person person : pple) {
            System.out.println(person);
        }
    }
}

// comparable is used to sort the objects based on single data member, its implemented by the class whose objects are to be sorted
// comparator is used to sort the objects based on multiple data members, its implemented by a separate class