package DesignPatterns.Creational.Factory;

public class Main {
    // factory pattern is a creational pattern that provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created
    // factory pattern is used when a class can't anticipate the class of objects it must create
    // factory pattern is used when a class wants its subclasses to specify the objects it creates
    // factory pattern is used when classes delegate responsibility to one of several helper subclasses, and you want to localize the knowledge of which helper subclass is the delegate
    public static void main(String[] args) {
        VehicleFactory carFactory = new CarFactory();
        Vehicle car = carFactory.createVehicle("Car");
        car.drive();

        VehicleFactory truckFactory = new TruckFactory();
        Vehicle truck = truckFactory.createVehicle("Truck");
        truck.drive();

        VehicleFactory bikeFactory = new BikeFactory();
        Vehicle bike = bikeFactory.createVehicle("Bike");
        bike.drive();
    }

    // When to Use the Factory Pattern
    //When the exact type of object to be created isn't known until runtime.
    //When you want to create objects from a family of related classes.
    //When the creation process of objects is complex or involves several steps, and you want to hide that complexity from the client.
    //When you want to decouple the client from the object creation process.
}
