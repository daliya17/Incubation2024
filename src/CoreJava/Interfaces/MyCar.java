package CoreJava.Interfaces;

public class MyCar implements Drivable, Serviceable {
    @Override
    public void drive() {
        System.out.println("Car is driving");
    }

    @Override
    public void service() {
        System.out.println("Car is being serviced");
    }
}
