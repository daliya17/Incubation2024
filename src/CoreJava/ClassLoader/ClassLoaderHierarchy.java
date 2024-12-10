package CoreJava.ClassLoader;

public class ClassLoaderHierarchy {

    public static void getClassLoaders(){
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
      //  while (classLoader != null) {
            System.out.println(classLoader);
            classLoader = classLoader.getParent();
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
      //  }
    }
    public static  void main(String args[]){
        getClassLoaders();
    }
}
