package DesignPatterns.Structural.Decorator;

import java.security.InvalidParameterException;

public class OrangeCone implements IceCreamCone {

    private final IceCreamCone iceCreamCone;

    public OrangeCone(IceCreamCone iceCreamCone) {
        if(iceCreamCone.getConstituents().contains("scoop")){
            throw new InvalidParameterException();
        }
        this.iceCreamCone = iceCreamCone;
    }

    @Override
    public int getCost() {
        return iceCreamCone.getCost() + 5;
    }

    @Override
    public String getConstituents() {
        return iceCreamCone.getConstituents() +" "+ "Orange Cone";
    }
}
