package StrategyPattern;

public class WalkTravelStrategy implements TravelStrategy {
    @Override
    public int getTime(int start, int end) {
        int distance = end - start;
        return distance * 2;
    }
}
