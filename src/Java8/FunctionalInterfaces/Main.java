package Java8.FunctionalInterfaces;

public class Main {
    public static void main(String[] args){
        MyExtendedInterface addfunction = (a,b)->a+b;
        System.out.println( addfunction.add(2,3));
        Myclass myclass = new Myclass();
        MyExtendedInterface addFunction2 = myclass::addNumbers;
        System.out.println(addFunction2.add(5,6));
    }
}
