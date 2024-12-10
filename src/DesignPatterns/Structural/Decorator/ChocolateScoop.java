package DesignPatterns.Structural.Decorator;

public class ChocolateScoop implements IceCreamCone {

    private final IceCreamCone iceCreamCone;

    public ChocolateScoop(IceCreamCone iceCreamCone) {
        this.iceCreamCone = iceCreamCone;
    }

    @Override
    public int getCost() {
        return iceCreamCone.getCost() + 5;
    }

    @Override
    public String getConstituents() {
        return iceCreamCone.getConstituents() +" "+ "Chocolate Scoop";
    }
}
