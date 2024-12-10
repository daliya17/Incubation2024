package DesignPatterns.Creational.Factory;

public class TruckFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle(String vehicleType) {
        return new Truck();
    }
}
