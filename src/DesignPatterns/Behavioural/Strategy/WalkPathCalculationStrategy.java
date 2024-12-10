package DesignPatterns.Behavioural.Strategy;

public class WalkPathCalculationStrategy implements PathCalculationStrategy{
    @Override
    public void CalculatePath() {
        System.out.println("Calculating path for walking");
    }
}
