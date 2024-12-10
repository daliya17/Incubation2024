package CoreJava.Exceptions;

public class CustomExceptionExample {
    public static void validateAge(int age) throws InvalidAgeException {
        if(age<18){
            throw new InvalidAgeException("Age is not valid");
        }
        else{
            System.out.println("Age is valid");
        }
    }
}
