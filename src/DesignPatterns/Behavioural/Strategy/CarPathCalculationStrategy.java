package DesignPatterns.Behavioural.Strategy;

public class CarPathCalculationStrategy implements PathCalculationStrategy{
    @Override
    public void CalculatePath() {
        System.out.println("Calculating path for car");
    }
}
