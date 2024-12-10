package DesignPatterns.Creational.Singleton;

public enum SingletonEnum {

    INSTANCE; // single instance

    private String message;
    SingletonEnum(){
        message = "SingletonEnum";
    }

    public void displayMessage(){
        System.out.println(message);
    }
}
