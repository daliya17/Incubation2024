package DesignPatterns.Behavioural.Strategy;

public class Main {

    // strategy pattern is used when we have multiple algorithm for a specific task and client decides the actual implementation to be used at runtime
    // strategy pattern is used when we want to define a class that will have one behaviour that is similar to other behaviours in a list
    // strategy pattern is used when we need to use one of the several behaviours dynamically
    public static void main(String[] args){
        PathCalculationStrategy pathCalculationStrategy = new WalkPathCalculationStrategy();
        pathCalculationStrategy.CalculatePath();
        pathCalculationStrategy = new CarPathCalculationStrategy();
        pathCalculationStrategy.CalculatePath();
        pathCalculationStrategy = new BikePathCalculationStrategy();
        pathCalculationStrategy.CalculatePath();
    }
}
