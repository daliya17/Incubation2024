package DesignPatterns.Behavioural.Strategy;

public class BikePathCalculationStrategy implements PathCalculationStrategy{
    @Override
    public void CalculatePath() {
        System.out.println("Calculating path for bike");
    }
}
