package DesignPatterns.Structural.Adapter;

public interface PaymentGatewayInterface {

    void doPayment(String paymentType, double amount);

    boolean checkPaymentStatus(String paymentType, double amount);
}
