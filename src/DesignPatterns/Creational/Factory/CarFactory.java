package DesignPatterns.Creational.Factory;

public class CarFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle(String vehicleType) {
        return new Car();
    }
}
