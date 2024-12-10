import CoreJava.Oops.Abstraction.Bike;
import CoreJava.Oops.Abstraction.Car;
import CoreJava.Oops.Abstraction.Vehicle;
import CoreJava.Oops.Encapsulation.BankAccount;
import CoreJava.Oops.Inheritance.Animal;
import CoreJava.Oops.Inheritance.Dog;
import CoreJava.Interfaces.MyCar;
import CoreJava.Oops.Polymorphism.Circle;
import CoreJava.Oops.Polymorphism.Rectangle;
import CoreJava.Oops.Polymorphism.Shape;

public class Main {
    public static void main(String[] args) {

        BankAccount account = new BankAccount(1000.00);
        account.deposit(500.00);
        account.withdraw(200.00);
        System.out.println("Current Balance: " + account.getBalance());

        Animal myAnimal = new Animal();
        Animal myDog = new Dog();

        myAnimal.sound();
        myDog.sound();

        Shape shape1 = new Circle();
        Shape shape2 = new Rectangle();

        shape1.draw();
        shape2.draw();

        Vehicle myCar = new Car();
        Vehicle myBike = new Bike();

        myCar.start();
        myCar.stop();

        myBike.start();
        myBike.stop();

        MyCar car = new MyCar();
        car.drive();
        car.service();
    }
}