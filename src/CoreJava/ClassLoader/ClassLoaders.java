package CoreJava.ClassLoader;

import java.sql.DriverManager;
import java.util.ArrayList;

public class ClassLoaders {
    public static void printClassLoaders(){
        System.out.println("Classloader of this class:" + ClassLoaders.class.getClassLoader());
        System.out.println("Classloader of this class:" + MyClass.class.getClassLoader());
        System.out.println("Classloader of DriverManager:" + DriverManager.class.getClassLoader());
        System.out.println("Classloader of ArrayList:" + ArrayList.class.getClassLoader());
    }

    public static void main(String args[]) {
        try {
            printClassLoaders();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
