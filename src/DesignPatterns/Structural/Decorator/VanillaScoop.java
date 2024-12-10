package DesignPatterns.Structural.Decorator;

public class VanillaScoop implements IceCreamCone {

    private final IceCreamCone iceCreamCone;

    public VanillaScoop(IceCreamCone iceCreamCone) {
        this.iceCreamCone = iceCreamCone;
    }

    @Override
    public int getCost() {
        return iceCreamCone.getCost() + 5;
    }

    @Override
    public String getConstituents() {
        return iceCreamCone.getConstituents() +" "+ "Vanilla Scoop";
    }
}
