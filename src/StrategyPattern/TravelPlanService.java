package StrategyPattern;

public class TravelPlanService {
    public TravelPlanService() {
    }

    public TravelStrategy getTravelStrategy(String pathTaken) {
        if (pathTaken.equals(TravelPlan.CAR.toString())) {
            return new CarTravelStrategy();
        }
        if (pathTaken.equals(TravelPlan.WALK.toString())) {
            return new WalkTravelStrategy();
        }
        return new CarTravelStrategy();
    }

}
