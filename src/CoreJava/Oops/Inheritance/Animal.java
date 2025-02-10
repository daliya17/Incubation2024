package CoreJava.Oops.Inheritance;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    public void sound() {
        System.out.println("CoreJava.Oops.Inheritance.Animal makes a sound");
    }

    public List<?super String> name() {
        return new ArrayList<>(List.of("Animal name"));
    }

    public Mammal getMammal(){
        return new Man();
    }
}

