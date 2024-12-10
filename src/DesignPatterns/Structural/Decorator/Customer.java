package DesignPatterns.Structural.Decorator;

public class Customer {

    // decorator pattern is used to add new functionality to an object without altering its structure
    // it is used to add new features to an object dynamically

    public static void main(String[] args) {
        IceCreamCone chocobar = new ChocolateScoop(new ChocolateScoop(new BlueCone()));
        System.out.println(chocobar.getConstituents());
        System.out.println(chocobar.getCost());

        IceCreamCone kesarPista = new VanillaScoop(new VanillaScoop(new BlueCone()));
        System.out.println(kesarPista.getConstituents());
        System.out.println(kesarPista.getCost());

    }
}
