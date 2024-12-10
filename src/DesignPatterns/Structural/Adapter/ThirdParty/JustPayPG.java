package DesignPatterns.Structural.Adapter.ThirdParty;

public class JustPayPG {
    public void doPayment(String paymentType, double amount){
        System.out.println("Payment of "+amount+" done using "+paymentType);
    }
}
