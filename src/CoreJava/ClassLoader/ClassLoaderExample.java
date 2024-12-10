package CoreJava.ClassLoader;

import java.util.ArrayList;

public class ClassLoaderExample {


    public static void main(String args[]) {
        try {
            ClassLoader classLoader = ClassLoader.getSystemClassLoader();
            System.out.println("Class loader: " + classLoader);
            Class<?> classe = classLoader.loadClass(ArrayList.class.getName());
            System.out.println(classe.getName());
            classLoader = classLoader.getParent();
            System.out.println("Parent class loader: " + classLoader);
            Class<?> clazz = classLoader.loadClass(ArrayList.class.getName());
            System.out.println(clazz.getName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
