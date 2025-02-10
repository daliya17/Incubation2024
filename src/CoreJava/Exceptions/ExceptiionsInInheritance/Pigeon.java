package CoreJava.Exceptions.ExceptiionsInInheritance;

public class Pigeon extends Bird {

    @Override
    public void fly() throws RuntimeException {
        System.out.println("Pigeon Flies");
    }
}
