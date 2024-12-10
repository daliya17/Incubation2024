package DesignPatterns.Structural.Adapter.ThirdParty;

public class CCAvenuePG {
    public void doPayment(String paymentType, double amount){
        System.out.println("Payment of "+amount+" done using "+paymentType);
    }
}
