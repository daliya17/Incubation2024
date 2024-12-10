package DesignPatterns.Structural.Decorator;

import java.security.InvalidParameterException;

public class BlueCone implements IceCreamCone {

    public BlueCone(IceCreamCone iceCreamCone) {
        if(iceCreamCone.getConstituents().contains("scoop")){
            throw new InvalidParameterException();
        }
    }

    public BlueCone() {
    }

    @Override
    public int getCost() {
        return 10;
    }

    @Override
    public String getConstituents() {
        return "Blue Cone";
    }
}
