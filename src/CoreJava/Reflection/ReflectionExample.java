package CoreJava.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ReflectionExample {
    // reflection is the ability to inspect and modify classes, interfaces, fields, and methods at runtime.
    public static void main(String[] args) throws NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
       Person person = new Person(20, "Naman");
        relection(person);
    }

    static void relection(Object obj) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
      Class objClass = obj.getClass();
        System.out.println("Class Name: " + objClass.getName());
        for(Field field: objClass.getDeclaredFields()){
            System.out.println("Field Name: " + field.getName());
            System.out.println("Field Type: " + field.getType());
        }
        // create object using reflection
        Constructor<?>[] constructors = objClass.getConstructors();
       Constructor<?> constructor= Arrays.stream(constructors).findFirst().get();
        System.out.println("Constructor Name: " + constructor.getName());
        Object person1 = constructor.newInstance( 20, "India");
        System.out.println("Object Created: " + person1.getClass());
        System.out.println("Object Created: " + person1.hashCode());
        Person person = (Person) person1;
        System.out.println("Age: " + person.getAge());
        System.out.println("Name: " + person.getName());

        //accessing private field
        Field field = objClass.getDeclaredField("name");
        field.setAccessible(true);

        String name = (String) field.get(obj);
        System.out.println("Value of name: " + name);
    }

}

