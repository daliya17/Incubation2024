package DesignPatterns.Behavioural.Strategy;

public class PathCalculationStrategyFactory {

    public PathCalculationStrategy getPathCalculationStrategy(TransportMode mode) {
        if (mode.equals("CAR"))
            return new CarPathCalculationStrategy();
        else if (mode.equals("WALK"))
            return new WalkPathCalculationStrategy();
        else if (mode.equals("BIKE"))
            return new BikePathCalculationStrategy();

        return null;
    }
}
