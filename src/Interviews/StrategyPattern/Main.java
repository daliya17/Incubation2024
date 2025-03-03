package Interviews.StrategyPattern;

public class Main {
    public static void main(String[] args) {
        String pathTaken = "WALK";
        TravelPlanService travelPlanService = new TravelPlanService();
        TravelStrategy travelStrategy = travelPlanService.getTravelStrategy(pathTaken);

        System.out.println("Travel by walk");
        System.out.println(travelStrategy.getTime(10, 20));

        System.out.println("Travel by car");
        System.out.println(travelPlanService.getTravelStrategy("CAR").getTime(10, 20));
    }
}
