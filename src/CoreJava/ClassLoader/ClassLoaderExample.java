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

    // class loader in java is used to load classes at runtime.
    // There are three types of class loaders in java:
    // 1. Bootstrap class loader
    // 2. Extension class loader
    // 3. System class loader
    // Bootstrap class loader is responsible for loading standard JDK classes.
    // Extension class loader is responsible for loading classes from the extension directory.
    // System class loader is responsible for loading classes from the classpath.
    // Class loader in java works on delegation model.
      // Class loader in java is used for dynamic class loading.
    // Bootstrap class loader is the parent of all class loaders in java, but it is not represented by any object. It is a part of the JVM.
    // Extension class loader is the child of bootstrap class loader and the parent of system class loader.
    // System class loader is the child of extension class loader.
    // platform class loader is another name for extension class loader from java 9.
    // application class loader is another name for system class loader from java 9.
    // delegation model is used by class loaders in java to load classes.
    // first class loader in the hierarchy is asked to load the class, if it is not able to load the class, then it delegates the request to its parent class loader.
    // this process continues until the class is loaded or the top-level class loader is reached.

}
