package CoreJava.Annotations;

public class UserService implements UserOperations{
    @Override
    public void performOperation() {
        System.out.println("Performing operation");
    }
}
