package StrategyPattern;

public class CarTravelStrategy implements TravelStrategy {
    @Override
    public int getTime(int start, int end) {
        return (end-start)*(1);
    }
}
