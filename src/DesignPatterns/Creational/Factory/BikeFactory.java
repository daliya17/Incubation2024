package DesignPatterns.Creational.Factory;

public class BikeFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle(String vehicleType) {
        return new Bike();
    }
}
